package com.julius.stocklookup.service;

import com.julius.stocklookup.model.StockWrapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.DAYS;
import static java.util.concurrent.TimeUnit.SECONDS;

@Service
public class RefreshService {
    private  Map<StockWrapper, Boolean> stocksToRefresh;
    private static  ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);
  //  private static final Duration refreshPeriod = Duration.ofSeconds(15);

    public RefreshService() {
        stocksToRefresh = new HashMap<>();
        shouldRefreshEvery15minutes();
    }

    public boolean shouldRefresh(StockWrapper stock){
        if(!stocksToRefresh.containsKey(stock)){
            stocksToRefresh.put(stock,false);
            return true;
        }

        return stocksToRefresh.get(stock);
    }

    private void shouldRefreshEvery15minutes() {
        scheduler.scheduleAtFixedRate(() ->
                stocksToRefresh.forEach((stock, value) -> {

                    if (LocalDateTime.now().minus(Duration.ofSeconds(10)).isAfter(stock.getLastAccessed())) {
                        System.out.println("Setting should refresh " +
                                stock.getStock().getSymbol());
                        stocksToRefresh.remove(stock);


                        stock.setLastAccessed(LocalDateTime.now());
                        stocksToRefresh.put(stock, true);
                    }
                }), 0, 15,  SECONDS);
    }
}
