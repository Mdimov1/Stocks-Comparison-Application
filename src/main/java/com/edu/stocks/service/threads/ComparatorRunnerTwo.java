/**
 * Copyright (C) 2022 Milen Dimov - All Rights Reserved
 */
package com.edu.stocks.service.threads;

import com.edu.stocks.service.comparator.StocksComparator;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ComparatorRunnerTwo implements Runnable {

    private Logger logger = Logger.getGlobal();

    private StocksComparator stocksComparator;

    public ComparatorRunnerTwo(StocksComparator stocksComparator){
        this.stocksComparator = stocksComparator;
    }

    @Override
    public void run() {
        logger.log(Level.INFO,"ComparatorRunnerTwo has been started.");

        if (stocksComparator != null) {
            stocksComparator.compareCashRatios();
            stocksComparator.compareGrossProfitMargins();
            stocksComparator.comparePriceToBookValueRatios();
            stocksComparator.comparePriceToSalesRations();
            stocksComparator.compareTangibleBookValue();
            stocksComparator.compareTrailingPriceEarningsRatios();
            stocksComparator.compareReturnOnEquities();
        }
    }
}
