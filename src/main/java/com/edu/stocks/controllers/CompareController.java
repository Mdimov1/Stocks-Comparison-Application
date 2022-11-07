/**
 * Copyright (C) 2022 Milen Dimov - All Rights Reserved
 */
package com.edu.stocks.controllers;

import com.edu.stocks.service.CompareService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/compare")
public class CompareController {
    private final String COMPARISON_FAILED_MESSAGE = "Stock comparison cannot be executed.";

    private CompareService compareService = new CompareService();

    @GetMapping("/all")
    public ResponseEntity<String> compareAllAvailableStocks() throws InterruptedException {
        String comparisonResults = compareService.compareAll();

        if (comparisonResults == null) {
            return new ResponseEntity<>(COMPARISON_FAILED_MESSAGE, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(comparisonResults, HttpStatus.OK);
    }

    @PostMapping("/custom")
    public ResponseEntity<String> compareCustomStocks(@RequestBody ObjectNode json) throws InterruptedException {
        // the stocks names must receive separated by whitespace
        String[] stockNames = json.get("stocksList").asText().split("//s+");
        String comparisonResults = compareService.compareCustomStocks(stockNames);

        if (comparisonResults == null) {
            return new ResponseEntity<>(COMPARISON_FAILED_MESSAGE, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(comparisonResults, HttpStatus.OK);
    }
}