/**
 * Copyright (C) 2022 Milen Dimov - All Rights Reserved
 */

import com.edu.stocks.threads.ComparatorRunnerOne;
import com.edu.stocks.threads.ComparatorRunnerTwo;
import com.edu.stocks.model.Stock;
import com.edu.stocks.threads.StocksResults;
import com.edu.stocks.comparator.StocksComparator;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        Stock tesla = new Stock(
                "Tesla", 907.34,
                333.33, 111.11,
                222.22, 444.44,
                555.5, 123.12,
                652.0, 33.0,
                22.0, 111.0,
                111.2, 222.1,
                333.1, 22.1,
                123.4);

        Stock nio = new Stock(
                "Nio", 27.34,
                323.33, 111.11,
                2.22, 44.4,
                515.5, 123.12,
                92.0, 23.0,
                22.0, 111.0,
                11.2, 222.1,
                123.1, 22.1,
                113.4);


        Stock wave = new Stock(
                "Wave", 5.34,
                23.33, 11.11,
                42.22, 44.4,
                515.5, 23.12,
                92.0, 23.0,
                22.0, 11.0,
                11.2, 22.1,
                12.1, 22.1,
                113.4);


        StocksComparator stocksComparator = new StocksComparator(tesla, nio, wave);

        ComparatorRunnerOne comparatorRunnerOne = new ComparatorRunnerOne(stocksComparator);
        ComparatorRunnerTwo comparatorRunnerTwo = new ComparatorRunnerTwo(stocksComparator);

        Thread thread1 = new Thread(comparatorRunnerOne);
        Thread thread2 = new Thread(comparatorRunnerTwo);

        // стартираме двете нишки, като във всяка се изпълняват половината от всички операции
        // така изпълняваме операциите паралелно, а не една по една
        thread1.start();
        thread2.start();

        StocksResults results = new StocksResults(stocksComparator);
        Thread threadResult = new Thread(results);
        threadResult.start();
        threadResult.join();
    }
}
