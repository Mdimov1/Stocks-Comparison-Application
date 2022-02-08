/**
 * Copyright (C) 2022 Milen Dimov - All Rights Reserved
 */
package com.edu.stocks.threads;

import com.edu.stocks.comparator.StocksComparator;

public class ComparatorRunnerTwo implements Runnable {

    private StocksComparator stocksComparator;

    public ComparatorRunnerTwo(StocksComparator stocksComparator){
        this.stocksComparator = stocksComparator;
    }

    @Override
    public void run() {
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
