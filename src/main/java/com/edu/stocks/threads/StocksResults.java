package com.edu.stocks.threads;

import com.edu.stocks.comparator.StocksComparator;

import java.util.Map;

public class StocksResults implements Runnable {
    private StocksComparator stocksComparator;

    public StocksResults(StocksComparator stocksComparator){
        this.stocksComparator = stocksComparator;
    }

    @Override
    public void run() {
        if (stocksComparator != null) {
            Map<Integer, String> results = stocksComparator.getStockResults();

            System.out.println("==================RESULTS==================");
            System.out.println("| The best stock to invest is number 1:");

            for (int i = results.size() - 1; i >= 0; i--) {
                System.out.println(String.format("| %s. %s", results.size() - i, results.values().toArray()[i]));
            }

            System.out.println("===========================================");
        }
    }
}
