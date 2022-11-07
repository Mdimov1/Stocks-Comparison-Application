/**
 * Copyright (C) 2022 Milen Dimov - All Rights Reserved
 */
package com.edu.stocks.service.interfaces;

public interface IStockStatistics {

    // TODO fix the javadoc
    /**
    Calculate and return the Gross Profit
    (брутната печалба, т.е. печалбата без да са извадени всички разходи)
    */
    public double getGrossProfit();

    /**
      Calculate and return the Gross Profit Margin
      Gross Profit Margin is what part in percentages of the revenue is in a Gross Profit
      (каква част от оборота се превръща в брутна печалба, в проценти)
    */
    public double getGrossProfitMargin();

    /*
      Calculate and return the Net Profit Margin - Нетна печалба
    */
    public double getNetProfitMargin();

    /*
      Calculate and return the Debt to Equity Ratio - Дълг спрямо чистия капитал
    */
    public double getDebtToEquityRatio();

    /*
      Calculate and return the Current Ratio - Текущото съотношение на активите спрямо дълговете
    */
    public double getCurrentRatio();

    /*
      Calculate and return the Quick Ratio - Бързо съотношение на активите минус стоката която не е продадена все още (инвентар) спрямо дълговете
    */
    public double getQuickRatio();

    /*
      Calculate and return the Cash Ratio - използваме го за да разберем дали дълговете са повече от кеш резервите на компанията
    */
    public double getCashRatio();

    /*
      Calculate and return the Price to Sales Ratio - една компания е подценена или надценена в текущия момент
    */
    public double getPriceToSalesRatio();

    /*
      Calculate and return the Return on Equity - Възвращаемост спрямо капитала
    */
    public double getReturnOnEquity();

    /*
      Calculate and return the Return on Assets - Възвращаемост спрямо активите
    */
    public double getReturnOnAssets();

    /*
      Calculate and return the Price to Book Value Ratio - Възвращаемост спрямо активите

      Този показател е подходящ за холдинг компании, производствени бизнеси и банки например компании като Coca Cola и Disney,
      не е подходящ за технологични (софтуерни) или бързо растящи компании като Netflix.
    */
    public double getPriceToBookValueRatio();

    /*
    public boolean isFastGrowing(){
        return stock.isFastGrowing();
    }
    */
    /*
      Calculate and return the Price to Tangible Book Value
    */
    public double getPriceToTangibleBookValue();

    /*
      Calculate and return the Trailing Price to Earnings Ratio
    */
    public double getTrailingPriceEarningsRatio();

    /*
      Calculate and return the Forward Price to Earnings Ratio
    */
    public double getFrowardPriceEarningsRatio();

    /*
      Calculate and return the PEG – Price/Earning to Growth Ratio
    */
    public double getPriceEarningsGrowthRatio();
}
