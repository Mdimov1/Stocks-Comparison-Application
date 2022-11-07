/**
 * Copyright (C) 2022 Milen Dimov - All Rights Reserved
 */
package com.edu.stocks.service;

import com.edu.stocks.model.MockDatabase.StocksStore;
import com.edu.stocks.model.Stock;
import com.edu.stocks.service.comparator.StocksComparator;
import com.edu.stocks.service.threads.ComparatorRunnerOne;
import com.edu.stocks.service.threads.ComparatorRunnerTwo;
import com.edu.stocks.service.threads.StocksComparisonResults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CompareService {

    private Logger logger = Logger.getGlobal();

    public String compareAll() throws InterruptedException {
        List<Stock> allStocks = StocksStore.getStocksDatabase();
        return compareStocks(allStocks);
    }

    public String compareCustomStocks(String... names) throws InterruptedException {
        List<Stock> customStocks = StocksStore.getCustomStocks(names);
        return compareStocks(customStocks);
    }

    private String compareStocks(List<Stock> stocks) throws InterruptedException {
        logger.info("Stocks comparison has been started.");

        StocksComparator stocksComparator = new StocksComparator(stocks);

        ComparatorRunnerOne comparatorRunnerOne = new ComparatorRunnerOne(stocksComparator);
        ComparatorRunnerTwo comparatorRunnerTwo = new ComparatorRunnerTwo(stocksComparator);

        Thread thread1 = new Thread(comparatorRunnerOne);
        Thread thread2 = new Thread(comparatorRunnerTwo);

        thread1.start();
        thread2.start();

        StocksComparisonResults comparisonResults = new StocksComparisonResults(stocksComparator);
        Thread threadResult = new Thread(comparisonResults);
        threadResult.start();
        threadResult.join();

        return comparisonResults.getResults();
    }
}
