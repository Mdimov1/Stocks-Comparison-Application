docker container run configs:
So, if we wanted to expose port 8000 inside the container to port 8080 outside the container, we would pass 8080:8000 to the --publish flag.


Docker configurations

1. Create Dockerfile

2. Build docker image based on this file:
   docker build -t stocks-app/local .
   
2. Run the docker image with proper port configuration:
   docker run -p 8080:8081 stocks-app/local --memory="200m" --memory-swap="500m"
   
3. Send curl requests to the the container with the configured port in step 2. (http://localhost:8080)

Kubernetes configurations https://www.docker.com/blog/how-to-use-your-own-registry-2/, 
https://matthewpalmer.net/kubernetes-app-developer/articles/service-kubernetes-example-tutorial.html

4. To use the created image in manifest file, first you need to upload it to image registry
  - Create local image registry:
       docker run -d -p 5000:5000 --name registry registry:2.7
  - get registry container logs: docker logs -f registry
  - get running pods: kubectl get pods
  - to delete pod: kubectl delete pod pod_name
  - to delete all deployments: kubectl delete --all deployments

5. tag the image with: docker tag stocks-app/local localhost:5000/stocks-app

6. push the tagged image to the local registry: docker push localhost:5000/stocks-app

7. Add the image name to the manifest file. Create the manifest file in the project:
# A deployment is responsible for keeping a set of pods running
kind: Deployment
apiVersion: apps/v1
metadata:
  name: stocks-comparator
spec:
  replicas: 1
  selector:
    matchLabels:
      app: stocks-comparator
  template:
    metadata:
      labels:
        app: stocks-comparator
    spec:
      containers:
        - name: stocks-comparator-pod
          image: localhost:5000/stocks-app
          ports:
            - containerPort: 8080
---
# A service is responsible for enabling network access to a set of pods.
kind: Service
apiVersion: v1
metadata:
  name: stocks-comparator
spec:
  # Expose the service on a static port on each node
  # so that we can access the service from outside the cluster
  type: NodePort
  # When the node receives a request on the static port (30163)
  # "select pods with the label 'app' set to 'echo-hostname'"
  # and forward the request to one of them
  selector:
    app: stocks-comparator
  ports:
    # Three types of ports for a service
    # nodePort - a static port assigned on each the node
    # port - port exposed internally in the cluster
    # targetPort - the container port to send requests to
    - nodePort: 30001
      port: 8081

8. Deploy the application: kubectl create -f deploy-stocks-comparator.yml
  - to delete the pods/deployment use: kubectl delete -f manifest-file-name.yml
  