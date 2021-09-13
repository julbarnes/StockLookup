package com.julius.stocklookup.service;

import com.julius.stocklookup.model.StockWrapper;
import org.springframework.stereotype.Service;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StockService {

    public StockWrapper findStock( String ticker) {
        try {
            return new StockWrapper(YahooFinance.get(ticker));
        } catch (IOException e) {
            System.out.println("error");
        }
        return null;
    }

    public BigDecimal findPrice( StockWrapper stock) throws IOException {
        return stock.getStock().getQuote(true).getPrice();
    }

    public List<StockWrapper> findStocks( List<String> tickers) {
        return tickers.stream().map(this::findStock).filter
                (Objects::nonNull).collect(Collectors.toList());

    }

    public BigDecimal findLastChangePercent( StockWrapper stock) throws IOException {

        return stock.getStock().getQuote(true).
                getChangeInPercent();
    }

    public BigDecimal findChangeFrom200MeanPercent( StockWrapper stock) throws IOException {
        return stock.getStock().getQuote(true).
                getChangeFromAvg200InPercent();

    }

}
