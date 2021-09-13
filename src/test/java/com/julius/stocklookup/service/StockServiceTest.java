package com.julius.stocklookup.service;

import com.julius.stocklookup.model.StockWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
class StockServiceTest {
    @Autowired
    private StockService stockService;

    @Test
    void invoke() throws IOException {
        final StockWrapper stock = stockService.findStock("AAPL");

        System.out.println(stock.getStock());

        final BigDecimal price = stockService.findPrice(stock);

        System.out.println(price);

        final BigDecimal change = stockService.findLastChangePercent(stock);

        System.out.println(change);

        BigDecimal mean200day = stockService.findChangeFrom200MeanPercent(stock);
        System.out.println(mean200day);
    }

    @Test
    void multiple() throws InterruptedException {
        final List<StockWrapper> stocks = stockService.findStocks
                (Arrays.asList("GOOG", "AMZN"));


        stocks.forEach(stock -> {
            try {
                System.out.println(stockService.findPrice(stock));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread.sleep(15000);

        stocks.forEach(stock -> {
            try {
                System.out.println(stockService.findPrice(stock));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }

}