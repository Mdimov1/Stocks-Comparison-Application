/**
 * Copyright (C) 2022 Milen Dimov - All Rights Reserved
 */
package com.edu.stocks.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Stock {

    // The name of the stock
    String name;

    // Price of the stock
    private Double price;

    // Can be found in the Income Statement. Revenue also known as Sales
    // Тhe income that the company receives regularly - Оборот
    private Double revenue;

    // Can be found in the Income Statement.
    // Истинската цена която е платена за да бъде направен оборота.
    // Примерно направили сме оборот от 1000 лв, но цената която ние сме дали за да го направим е 500, т.е. нашия разхот от тези 1000 лв., без данъци такси и други.
    private Double costOfRevenue;

    // Can be found in the Income Statement. Net Profit (Net Income)
    private Double netProfit;

    // Can be found in the Balance Sheet. Total Assets (Дългосрочни активи)
    private Double totalAssets;

    // Can be found in the Balance Sheet. Current Assets (Текущи активи)
    private Double currentAssets;

    // Can be found in the Balance Sheet. Tangible Book Value - Всички активи които могат да се пипнат, като сгради, оборудване, пари в кеш.
    private Double tangibleBookValue;

    // Can be found in the Balance Sheet. Total Liabilities (Дългосрочни дългове)
    private Double totalLiabilities;

    // Can be found in the Balance Sheet. Current Liabilities (Текущи дългове)
    private Double currentLiabilities;

    // Can be found in the Balance Sheet. Inventory (Инвентар, стоката която все още не е продадена)
    private Double inventory;

    // Can be found in the Balance Sheet. Shareholders Equity (чист капитал) is also known as Total Equity оr Stock Equity
    private Double shareholdersEquity;

    // Can be found in the Balance Sheet. Cash
    private Double cash;

    // Can be found in the Balance Sheet. Cash Equivalents (Бързо ликвидни активи)
    private Double cashEquivalents;

    // Trailing P/E ratio (Price/Earnings Ratio) - Цената спрямо нетната печалба за една акция за последните 12 месеца
    private Double trailingPriceToEarningsRatio;

    // Forward P/E ratio (Price/Earnings Ratio) - Представя очакваните печалби за следващите 12 месеца
    private Double forwardPriceToEarningsRatio;

    // PEG – Price/Earning to Growth ratio - Използваме го за разглеждане колко е подценена или надценена една компания спрямо растежа си
    private Double pegRatio;

    // If the company is fast growing. Default value true, not used for now
    private boolean fastGrowing = true;

    public Stock() {}

    public Stock(String name, Double price,
                 Double revenue, Double costOfRevenue,
                 Double netProfit, Double totalAssets,
                 Double currentAssets, Double tangibleBookValue,
                 Double totalLiabilities, Double currentLiabilities,
                 Double inventory, Double shareholdersEquity,
                 Double cash, Double cashEquivalents,
                 Double trailingPriceToEarningsRatio,
                 Double forwardPriceToEarningsRatio, Double pegRatio) {
        this.name = name;
        this.price = price;
        this.revenue = revenue;
        this.costOfRevenue = costOfRevenue;
        this.netProfit = netProfit;
        this.totalAssets = totalAssets;
        this.currentAssets = currentAssets;
        this.tangibleBookValue = tangibleBookValue;
        this.totalLiabilities = totalLiabilities;
        this.currentLiabilities = currentLiabilities;
        this.inventory = inventory;
        this.shareholdersEquity = shareholdersEquity;
        this.cash = cash;
        this.cashEquivalents = cashEquivalents;
        this.trailingPriceToEarningsRatio = trailingPriceToEarningsRatio;
        this.forwardPriceToEarningsRatio = forwardPriceToEarningsRatio;
        this.pegRatio = pegRatio;
    }

    /*
    public boolean isFastGrowing() {
        return fastGrowing;
    }

    public void setFastGrowing(boolean fastGrowing) {
        this.fastGrowing = fastGrowing;
    }
    */
}
