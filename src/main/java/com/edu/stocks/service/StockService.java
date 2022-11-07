/**
 * Copyright (C) 2022 Milen Dimov - All Rights Reserved
 */
package com.edu.stocks.service;

import com.edu.stocks.model.Stock;
import com.edu.stocks.service.interfaces.IStockStatistics;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class StockService implements IStockStatistics {

    Stock stock;

    public StockService(Stock stock){
        this.stock = stock;
    }

    @Override
    public double getGrossProfit() {
        return stock.getRevenue() - stock.getCostOfRevenue();
    }

    @Override
    public double getGrossProfitMargin() {
        return getGrossProfit() / stock.getRevenue();
    }

    @Override
    public double getNetProfitMargin() {
        return (stock.getNetProfit() / stock.getRevenue()) * 100;
    }

    @Override
    public double getDebtToEquityRatio() {
        return stock.getTotalLiabilities() / stock.getShareholdersEquity();
    }

    @Override
    public double getCurrentRatio() {
        return stock.getCurrentAssets() / stock.getCurrentLiabilities();
    }

    @Override
    public double getQuickRatio() {
        return (stock.getCurrentAssets() - stock.getInventory()) / stock.getCurrentLiabilities();
    }

    @Override
    public double getCashRatio() {
        return (stock.getCash() + stock.getCashEquivalents()) / stock.getCurrentLiabilities();
    }

    @Override
    public double getPriceToSalesRatio() {
        return stock.getPrice() / stock.getRevenue();
    }

    @Override
    public double getReturnOnEquity() {
        return (stock.getNetProfit() / stock.getShareholdersEquity()) * 100;
    }

    @Override
    public double getReturnOnAssets() {
        return (stock.getNetProfit() / stock.getTotalAssets()) * 100;
    }

    @Override
    public double getPriceToBookValueRatio() {
        return stock.getPrice() / stock.getShareholdersEquity();
    }

    @Override
    public double getPriceToTangibleBookValue() {
        return stock.getPrice() / stock.getTangibleBookValue();
    }

    @Override
    public double getTrailingPriceEarningsRatio() {
        return stock.getTrailingPriceToEarningsRatio();
    }

    @Override
    public double getFrowardPriceEarningsRatio() {
        return stock.getForwardPriceToEarningsRatio();
    }

    @Override
    public double getPriceEarningsGrowthRatio() {
        return stock.getPegRatio();
    }
}
