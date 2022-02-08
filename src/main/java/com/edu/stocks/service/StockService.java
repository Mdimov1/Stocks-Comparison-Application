/**
 * Copyright (C) 2022 Milen Dimov - All Rights Reserved
 */
package com.edu.stocks.service;

import com.edu.stocks.model.Stock;

public class StockService {

    // The stock which metrics we want to use in calculations
    Stock stock;

    public StockService(Stock stock){
        this.stock = stock;
    }

    /*
  Calculate and return the Gross Profit
  (брутната печалба, т.е. печалбата без да са извадени всички разходи)
 */
    public double getGrossProfit() {
        return stock.getRevenue() - stock.getCostOfRevenue();
    }

    /*
      Calculate and return the Gross Profit Margin
      Gross Profit Margin is what part in percentages of the revenue is in a Gross Profit
      (каква част от оборота се превръща в брутна печалба, в проценти)
    */
    public double getGrossProfitMargin() {
        return getGrossProfit() / stock.getRevenue();
    }

    /*
      Calculate and return the Net Profit Margin - Нетна печалба
    */
    public double getNetProfitMargin() {
        return (stock.getNetProfit() / stock.getRevenue()) * 100;
    }

    /*
      Calculate and return the Debt to Equity Ratio - Дълг спрямо чистия капитал
    */
    public double getDebtToEquityRatio() {
        return stock.getTotalLiabilities() / stock.getShareholdersEquity();
    }

    /*
      Calculate and return the Current Ratio - Текущото съотношение на активите спрямо дълговете
    */
    public double getCurrentRatio() {
        return stock.getCurrentAssets() / stock.getCurrentLiabilities();
    }

    /*
      Calculate and return the Quick Ratio - Бързо съотношение на активите минус стоката която не е продадена все още (инвентар) спрямо дълговете
    */
    public double getQuickRatio() {
        return (stock.getCurrentAssets() - stock.getInventory()) / stock.getCurrentLiabilities();
    }

    /*
      Calculate and return the Cash Ratio - използваме го за да разберем дали дълговете са повече от кеш резервите на компанията
    */
    public double getCashRatio() {
        return (stock.getCash() + stock.getCashEquivalents()) / stock.getCurrentLiabilities();
    }

    /*
      Calculate and return the Price to Sales Ratio - една компания е подценена или надценена в текущия момент
    */
    public double getPriceToSalesRatio() {
        return stock.getPrice() / stock.getRevenue();
    }

    /*
      Calculate and return the Return on Equity - Възвращаемост спрямо капитала
    */
    public double getReturnOnEquity() {
        return (stock.getNetProfit() / stock.getShareholdersEquity()) * 100;
    }

    /*
      Calculate and return the Return on Assets - Възвращаемост спрямо активите
    */
    public double getReturnOnAssets() {
        return (stock.getNetProfit() / stock.getTotalAssets()) * 100;
    }

    /*
      Calculate and return the Price to Book Value Ratio - Възвращаемост спрямо активите

      Този показател е подходящ за холдинг компании, производствени бизнеси и банки например компании като Coca Cola и Disney,
      не е подходящ за технологични (софтуерни) или бързо растящи компании като Netflix.
    */
    public double getPriceToBookValueRatio() {
        return stock.getPrice() / stock.getShareholdersEquity();
    }

    /*
    public boolean isFastGrowing(){
        return stock.isFastGrowing();
    }
    */
    /*
      Calculate and return the Price to Tangible Book Value
    */
    public double getPriceToTangibleBookValue() {
        return stock.getPrice() / stock.getTangibleBookValue();
    }

    /*
      Calculate and return the Trailing Price to Earnings Ratio
    */
    public double getTrailingPriceEarningsRatio() {
        return stock.getTrailingPriceToEarningsRatio();
    }

    /*
      Calculate and return the Forward Price to Earnings Ratio
    */
    public double getFrowardPriceEarningsRatio() {
        return stock.getForwardPriceToEarningsRatio();
    }

    /*
      Calculate and return the PEG – Price/Earning to Growth Ratio
    */
    public double getPriceEarningsGrowthRatio() {
        return stock.getPegRatio();
    }

    /*
      Get a stock name
    */
    public String getStockName() {
        return stock.getName();
    }
}
