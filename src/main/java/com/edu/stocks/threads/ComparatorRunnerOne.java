/**
 * Copyright (C) 2022 Milen Dimov - All Rights Reserved
 */
package com.edu.stocks.threads;

import com.edu.stocks.comparator.StocksComparator;

public class ComparatorRunnerOne implements Runnable {

    private StocksComparator stocksComparator;

    public ComparatorRunnerOne(StocksComparator stocksComparator){
        this.stocksComparator = stocksComparator;
    }

    @Override
    public void run() {
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
