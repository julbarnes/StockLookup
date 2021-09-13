package com.julius.stocklookup.service;

import com.julius.stocklookup.model.StockTrader;
import com.julius.stocklookup.repository.StockTraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockTraderService {

    private StockTraderRepository stockTraderRepository;


    @Autowired
    public StockTraderService(StockTraderRepository stockTraderRepository) {
        this.stockTraderRepository = stockTraderRepository;
    }

    public List<StockTrader> getStockTraders() {
        return stockTraderRepository.findAll();
    }

    public void addNewStockTrader(StockTrader stockTrader) {
        System.out.println(stockTrader);

    }

}
