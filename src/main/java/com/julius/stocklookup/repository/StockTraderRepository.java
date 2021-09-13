package com.julius.stocklookup.repository;

import com.julius.stocklookup.model.StockTrader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTraderRepository extends JpaRepository<StockTrader,Long> {

}
