/**
 * Copyright (C) 2022 Milen Dimov - All Rights Reserved
 */
package com.edu.stocks.model.MockDatabase;

import com.edu.stocks.model.Stock;
import com.edu.stocks.service.exceptions.StockNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class StocksStore {
    private Logger logger = Logger.getGlobal();

    private static List<Stock> stocksDatabase;

    public StocksStore() {
        stocksDatabase = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocksDatabase.add(stock);

        logger.log(Level.INFO, "Stock {0} has been added.", stock.getName());
    }

    public void removeStock(String stockName) {
        Stock stock = getStockByName(stockName);

        if (stock == null) {
            throw new StockNotFoundException(stockName);
        }
        stocksDatabase.remove(stock);
    }

    private static Stock getStockByName(String wantedStockName) {
        Stock currentStock = null;

        for (int i = 0; i < stocksDatabase.size(); i++) {
            currentStock = stocksDatabase.get(i);

            if (currentStock.getName().equals(wantedStockName)) {
                return currentStock;
            }
        }
        return null;
    }

    public static List<Stock> getStocksDatabase() {
        return stocksDatabase;
    }

    public static List<Stock> getCustomStocks(String... stocksNames) {
        List<Stock> customStocks = new ArrayList<>();
        Stock currentStock = null;

        for (int i = 0; i < stocksNames.length; i++) {
            currentStock = getStockByName(stocksNames[i]);
            if (currentStock != null) {
                customStocks.add(currentStock);
            }
        }

        return customStocks;
    }
}
