package com.julius.stocklookup.repository;

import com.julius.stocklookup.model.StockPortfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StocksPortfolioRepository extends JpaRepository<StockPortfolio,Long> {
}
