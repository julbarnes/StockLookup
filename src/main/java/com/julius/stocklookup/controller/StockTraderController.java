package com.julius.stocklookup.controller;


import com.julius.stocklookup.model.StockTrader;
import com.julius.stocklookup.service.StockTraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/stocktrader")
public class StockTraderController {

    private StockTraderService stockTraderService;

    @Autowired
    public StockTraderController(StockTraderService stockTraderService){
        this.stockTraderService = stockTraderService;
    }

    @GetMapping
    public List<StockTrader> getStockTraderUsers() {
        return stockTraderService.getStockTraders();
    }

    @PostMapping
    public void registerNewStockTrader(@RequestBody StockTrader stockTrader) {
        stockTraderService.addNewStockTrader(stockTrader);
    }



}
