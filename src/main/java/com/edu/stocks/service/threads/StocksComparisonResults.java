/**
 * Copyright (C) 2022 Milen Dimov - All Rights Reserved
 */
package com.edu.stocks.service.threads;

import com.edu.stocks.service.comparator.StocksComparator;

import java.util.Map;

public class StocksComparisonResults implements Runnable {
    private StocksComparator stocksComparator;
    private StringBuilder resultsMessage = new StringBuilder();

    public StocksComparisonResults(StocksComparator stocksComparator){
        this.stocksComparator = stocksComparator;
    }

    @Override
    public void run() {
        if (stocksComparator != null) {
            Map<Integer, String> results = stocksComparator.getStockResults();

            resultsMessage.append("|=================RESULTS=================|\n" +
                                  "|        The best stocks to invest        |\n");

            String stockName;

            for (int i = results.size() - 1; i >= 0; i--) {
                stockName = (String) results.values().toArray()[i];

                resultsMessage.append(String.format("| %s. %s", results.size() - i, stockName));
                resultsMessage.append(String.format("%s|\n", " ".repeat(37 - stockName.length())));
            }

            resultsMessage.append("|=========================================|");
        }
    }

    public String getResults() {
        return resultsMessage.toString();
    }
}
