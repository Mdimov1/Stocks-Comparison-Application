/**
 * Copyright (C) 2022 Milen Dimov - All Rights Reserved
 */
package com.edu.stocks.comparator;

import com.edu.stocks.model.Stock;
import com.edu.stocks.service.StockService;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Compare class which purpose is to compare a given stock, to help us
 * to identify which of them is the best choice for investing in it.
 */
public class StocksComparator {

    // List with all stocks services for the stocks
    private StockService[] stockServices;

    // Count of the stocks
    private int stocksCount;

    // Array with length the count of stocks. It will be used for store every stock points. We weill categorize the stocks.
    // That one with the most points is the best for investing in it.
    private int[] stockPoints;

    // Map which contains the points and names of the stocks
    private Map<Integer, String> stocksResults = new TreeMap<Integer, String>();

    public StocksComparator(Stock... stocks) {
        this.stocksCount = stocks.length;
        this.stockPoints = new int[stocksCount];
        this.stockServices = new StockService[stocksCount];

        for (int i = 0; i < stocksCount; i++) {
            this.stockServices[i] = new StockService(stocks[i]);
        }
    }

    private void increaseStockPoints(int stockPointsIndex) throws IndexOutOfBoundsException {
        if (stockPointsIndex > stockPoints.length) {
            throw new IndexOutOfBoundsException("The provided stock index is invalid. The stock points list size is " + stockPoints.length);
        }

        stockPoints[stockPointsIndex]++;
    }

    /**
     * This function calls the method getGrossProfitMargin for every stock service,
     * compare all Gross Profit Margins and increase the points of the stock
     * with the best Gross Profit Margin.
     */
    public void compareGrossProfitMargins() {
        int stockIndex = 0;
        double highestValue = stockServices[0].getGrossProfitMargin();

        for (int i = 1; i < stocksCount; i++) {
            double currentGrossProfitMargin = stockServices[i].getGrossProfitMargin();

            if (currentGrossProfitMargin > highestValue) {
                highestValue = currentGrossProfitMargin;
                stockIndex = i;
            }
        }

        increaseStockPoints(stockIndex);
    }

    /**
     * This function calls the method getNetProfitMargin for every stock service,
     * compare all Net Profit Margins and increase the points of the stock
     * with the best Net Profit Margin.
     */
    public void compareNetProfitMargins() {
        int stockIndex = 0;
        double highestValue = stockServices[0].getNetProfitMargin();

        for (int i = 1; i < stocksCount; i++) {
            double currentNetProfitMargin = stockServices[i].getNetProfitMargin();

            if (currentNetProfitMargin > highestValue) {
                highestValue = currentNetProfitMargin;
                stockIndex = i;
            }
        }

        increaseStockPoints(stockIndex);
    }

    /**
     * This function calls the method getDebtToEquityRatio for every stock service,
     * compare all Debt to Equity Ratios and increase the points of the stock
     * with the best Debt to Equity Ratio.
     */
    public void compareDebtToEquityRatios() {
        int stockIndex = 0;
        double lowestValue = stockServices[0].getDebtToEquityRatio();

        for (int i = 1; i < stocksCount; i++) {
            double currentDebtToEquityRatio = stockServices[i].getDebtToEquityRatio();

            if (currentDebtToEquityRatio < lowestValue) {
                lowestValue = currentDebtToEquityRatio;
                stockIndex = i;
            }
        }

        increaseStockPoints(stockIndex);
    }

    /**
     * This function calls the method getCurrentRatio for every stock service,
     * compare all Current Ratios and increase the points of the stock
     * with the best Current Ratio.
     */
    public void compareCurrentRatios() {
        int stockIndex = 0;
        double highestValue = stockServices[0].getCurrentRatio();

        for (int i = 1; i < stocksCount; i++) {
            double currentCurrentRatio = stockServices[i].getCurrentRatio();

            if (currentCurrentRatio > highestValue) {
                highestValue = currentCurrentRatio;
                stockIndex = i;
            }
        }

        increaseStockPoints(stockIndex);
    }

    /**
     * This function calls the method getQuickRatio for every stock service,
     * compare all Quick Ratios and increase the points of the stock
     * with the best Quick Ratio.
     */
    public void compareQuickRatios() {
        int stockIndex = 0;
        double highestValue = stockServices[0].getQuickRatio();

        for (int i = 1; i < stocksCount; i++) {
            double currentQuickRatio = stockServices[i].getQuickRatio();

            if (currentQuickRatio > highestValue) {
                highestValue = currentQuickRatio;
                stockIndex = i;
            }
        }

        increaseStockPoints(stockIndex);
    }

    /**
     * This function calls the method getCashRatio for every stock service,
     * compare all Cash Ratios and increase the points of the stock
     * with the best Cash Ratio.
     */
    public void compareCashRatios() {
        int stockIndex = 0;
        double highestValue = stockServices[0].getCashRatio();

        for (int i = 1; i < stocksCount; i++) {
            double currentCashRatio = stockServices[i].getCashRatio();

            if (currentCashRatio > highestValue) {
                highestValue = currentCashRatio;
                stockIndex = i;
            }
        }

        increaseStockPoints(stockIndex);
    }

    /**
     * This function may be modified for the future, because it should be executed only for fast growing companies.
     * <p>
     * This function calls the method getPriceToSalesRatio for every stock service,
     * compare all Price to Sales Rations and increase the points of the stock
     * with the best Price to Sales Ration.
     */
    public void comparePriceToSalesRations() {
        int stockIndex = Integer.MIN_VALUE;
        double lowestValue = Double.MAX_VALUE;

        for (int i = 0; i < stocksCount; i++) {
            //if (stockServices[i].isFastGrowing()) {
            double currentPriceToSalesRatio = stockServices[i].getPriceToSalesRatio();

            if (currentPriceToSalesRatio < lowestValue) {
                lowestValue = currentPriceToSalesRatio;
                stockIndex = i;
            }
            //}
        }

        if (stockIndex != Integer.MIN_VALUE) {
            increaseStockPoints(stockIndex);
        }
    }

    /**
     * This function calls the method getReturnOnEquity for every stock service,
     * compare all Return on Equities and increase the points of the stock
     * with the best Return on Equity.
     */
    public void compareReturnOnEquities() {
        int stockIndex = 0;
        double highestValue = Double.MIN_VALUE;

        for (int i = 0; i < stocksCount; i++) {
            double currentReturnOnEquity = stockServices[i].getReturnOnEquity();

            if (currentReturnOnEquity > 0.10 && currentReturnOnEquity > highestValue) {
                highestValue = currentReturnOnEquity;
                stockIndex = i;
            }
        }

        if (highestValue != Double.MIN_VALUE) {
            increaseStockPoints(stockIndex);
        }
    }

    /**
     * This function calls the method getReturnOnAssets for every stock service,
     * compare all Return on Assets and increase the points of the stock
     * with the best Return on Assets.
     */
    public void compareReturnOnAssets() {
        int stockIndex = 0;
        double highestValue = stockServices[0].getReturnOnAssets();

        for (int i = 1; i < stocksCount; i++) {
            double currentReturnOnAssets = stockServices[i].getReturnOnAssets();

            if (currentReturnOnAssets > highestValue) {
                highestValue = currentReturnOnAssets;
                stockIndex = i;
            }
        }

        increaseStockPoints(stockIndex);
    }

    /**
     * This function calls the method getTrailingPriceEarningsRatio for every stock service,
     * compare all Trailing Price/Earnings Ratios and increase the points of the stock
     * with the best Trailing Price/Earnings Ratio.
     */
    public void compareTrailingPriceEarningsRatios() {
        int stockIndex = 0;
        double lowestValue = stockServices[0].getTrailingPriceEarningsRatio();

        for (int i = 1; i < stocksCount; i++) {
            double currentTrailingPriceEarningsRatio = stockServices[i].getTrailingPriceEarningsRatio();

            if (currentTrailingPriceEarningsRatio < lowestValue) {
                lowestValue = currentTrailingPriceEarningsRatio;
                stockIndex = i;
            }
        }

        increaseStockPoints(stockIndex);
    }

    /**
     * This function calls the method getFrowardPriceEarningsRatio for every stock service,
     * compare all Froward Price/Earnings Ratios and increase the points of the stock
     * with the best Froward Price/Earnings Ratio.
     */
    public void compareFrowardPriceEarningsRatios() {
        int stockIndex = 0;
        double highestValue = stockServices[0].getFrowardPriceEarningsRatio();

        for (int i = 1; i < stocksCount; i++) {
            double currentFrowardPriceEarningsRatio = stockServices[i].getFrowardPriceEarningsRatio();

            if (currentFrowardPriceEarningsRatio > highestValue) {
                highestValue = currentFrowardPriceEarningsRatio;
                stockIndex = i;
            }
        }

        increaseStockPoints(stockIndex);
    }

    /**
     * This criteria is good to be used for holdings, natural products companies and banks,
     * it may be not used for technology (software) companies and fast growing ones.
     * <p>
     * This function calls the method getPriceToBookValueRatio for every stock service,
     * compare all Price to Book Value Ratios and increase the points of the stock
     * with the best Price to Book Value Ratio.
     */
    public void comparePriceToBookValueRatios() {
        int stockIndex = 0;
        double lowestValue = stockServices[0].getPriceToBookValueRatio();

        for (int i = 1; i < stocksCount; i++) {
            double currentPriceToBookValueRatio = stockServices[i].getPriceToBookValueRatio();

            if (currentPriceToBookValueRatio < lowestValue) {
                lowestValue = currentPriceToBookValueRatio;
                stockIndex = i;
            }
        }

        increaseStockPoints(stockIndex);
    }

    /**
     * This function calls the method getPriceToTangibleBookValue for every stock service,
     * compare all Tangible Book Values and increase the points of the stock
     * with the best Tangible Book Value.
     */
    public void compareTangibleBookValue() {
        int stockIndex = 0;
        double highestValue = stockServices[0].getPriceToTangibleBookValue();

        for (int i = 1; i < stocksCount; i++) {
            double currentPriceToTangibleBookValue = stockServices[i].getPriceToTangibleBookValue();

            if (currentPriceToTangibleBookValue > highestValue) {
                highestValue = currentPriceToTangibleBookValue;
                stockIndex = i;
            }
        }

        increaseStockPoints(stockIndex);
    }

    /**
     * This function calls the method getPriceEarningsGrowthRatio for every stock service,
     * compare all Price/Earning to Growth Ratios and increase the points of the stock
     * with the best Price/Earning to Growth Ratio.
     */
    public void comparePriceEarningToGrowthRatio() {
        int stockIndex = 0;
        double lowsetValue = stockServices[0].getPriceEarningsGrowthRatio();

        for (int i = 1; i < stocksCount; i++) {
            double currentPriceEarningsGrowthRatio = stockServices[i].getPriceEarningsGrowthRatio();

            if (currentPriceEarningsGrowthRatio < lowsetValue) {
                lowsetValue = currentPriceEarningsGrowthRatio;
                stockIndex = i;
            }
        }

        increaseStockPoints(stockIndex);
    }

    /**
     * Fill a Map with the points of the stocks paired with their names
     *
     * @return map of the stocks points and names
     */
    public Map<Integer, String> getStockResults() {
        for (int i = 0; i < stocksCount; i++) {
            stocksResults.put(stockPoints[i], stockServices[i].getStockName());
        }

        return stocksResults;
    }

    @Override
    public String toString() {
        return "CompareStocks{" +
                "stockPoints=" + Arrays.toString(stockPoints) +
                '}';
    }
}
