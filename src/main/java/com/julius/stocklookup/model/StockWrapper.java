package com.julius.stocklookup.model;

import yahoofinance.Stock;

import java.time.LocalDateTime;

public class StockWrapper {

    private Stock stock;
    private LocalDateTime lastAccessed;

    public StockWrapper( Stock stock){
        this.stock= stock;
        lastAccessed = LocalDateTime.now();
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setLastAccessed(LocalDateTime lastAccessed) {
         this.lastAccessed = lastAccessed;
    }
    public LocalDateTime getLastAccessed() {
        return lastAccessed;
    }
}
