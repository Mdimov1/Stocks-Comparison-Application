/**
 * Copyright (C) 2022 Milen Dimov - All Rights Reserved
 */
package com.edu.stocks.controllers;

import com.edu.stocks.model.MockDatabase.StocksStore;
import com.edu.stocks.model.Stock;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    private StocksStore database = new StocksStore();

    @PostMapping("/add")
    public void addNewStock(@RequestBody ObjectNode json) {
        final String name = json.get("name").asText();
        final Double price = json.get("price").asDouble();
        final Double revenue = json.get("revenue").asDouble();
        final Double costOfRevenue = json.get("costOfRevenue").asDouble();
        final Double netProfit = json.get("netProfit").asDouble();
        final Double totalAssets = json.get("totalAssets").asDouble();
        final Double currentAssets = json.get("currentAssets").asDouble();
        final Double tangibleBookValue = json.get("tangibleBookValue").asDouble();
        final Double totalLiabilities = json.get("totalLiabilities").asDouble();
        final Double currentLiabilities = json.get("currentLiabilities").asDouble();
        final Double inventory = json.get("inventory").asDouble();
        final Double shareholdersEquity = json.get("shareholdersEquity").asDouble();
        final Double cash = json.get("cash").asDouble();
        final Double cashEquivalents = json.get("cashEquivalents").asDouble();
        final Double trailingPriceToEarningsRatio = json.get("trailingPriceToEarningsRatio").asDouble();
        final Double forwardPriceToEarningsRatio = json.get("forwardPriceToEarningsRatio").asDouble();
        final Double pegRatio = json.get("pegRatio").asDouble();

        database.addStock(new Stock(name, price, revenue, costOfRevenue, netProfit, totalAssets, currentAssets,
                                tangibleBookValue, totalLiabilities, currentLiabilities, inventory,
                                shareholdersEquity, cash, cashEquivalents, trailingPriceToEarningsRatio,
                                forwardPriceToEarningsRatio, pegRatio));
    }

    @PostMapping("/remove")
    public void removeStock(@RequestBody ObjectNode json) {
        database.removeStock(json.get("name").asText());
    }
}