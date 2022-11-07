/**
 * Copyright (C) 2022 Milen Dimov - All Rights Reserved
 */
package com.edu.stocks.service.exceptions;

public class StockNotFoundException extends RuntimeException {
    private static String STOCK_NOT_FOUND_EXCEPTION_MESSAGE = "Stock with name %s does not exist in the database.";

    public StockNotFoundException(String message) {
        super(String.format(STOCK_NOT_FOUND_EXCEPTION_MESSAGE, message));
    }
}
