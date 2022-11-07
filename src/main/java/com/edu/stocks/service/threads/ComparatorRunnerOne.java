/**
 * Copyright (C) 2022 Milen Dimov - All Rights Reserved
 */
package com.edu.stocks.service.threads;

import com.edu.stocks.service.comparator.StocksComparator;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ComparatorRunnerOne implements Runnable {

    private Logger logger = Logger.getGlobal();

    private StocksComparator stocksComparator;

    public ComparatorRunnerOne(StocksComparator stocksComparator){
        this.stocksComparator = stocksComparator;
    }

    @Override
    public void run() {
        logger.log(Level.INFO,"ComparatorRunnerOne has been started.");

        if (stocksComparator != null){
            stocksComparator.compareCurrentRatios();
            stocksComparator.compareQuickRatios();
            stocksComparator.compareDebtToEquityRatios();
            stocksComparator.compareFrowardPriceEarningsRatios();
            stocksComparator.compareNetProfitMargins();
            stocksComparator.comparePriceEarningToGrowthRatio();
            stocksComparator.compareReturnOnAssets();
        }
    }
}
