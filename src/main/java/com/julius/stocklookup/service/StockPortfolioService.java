package com.julius.stocklookup.service;

import com.julius.stocklookup.model.StockPortfolio;
import com.julius.stocklookup.repository.StocksPortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StockPortfolioService {

    private StocksPortfolioRepository stocksPortfolioRepository;

    @Autowired
    public StockPortfolioService(StocksPortfolioRepository stocksPortfolioRepository) {
        this.stocksPortfolioRepository = stocksPortfolioRepository;
    }

    public List<StockPortfolio> getStockTradersPortfolios() {
        return stocksPortfolioRepository.findAll();
    }

}
