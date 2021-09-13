package com.julius.stocklookup.config;

import com.julius.stocklookup.model.StockTrader;
import com.julius.stocklookup.repository.StockTraderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StockTraderConfig {


    @Bean
    CommandLineRunner commandLineRunner(StockTraderRepository stockTraderRepository) {
        return args -> {
            StockTrader julius = new StockTrader("Julius", "julius888@gmail.com", LocalDate.of(1997, 10, 07));

            StockTrader tom = new StockTrader("Tom", "tom123@gmail.com", LocalDate.of(2010, 01, 12));

            stockTraderRepository.saveAll(List.of(julius, tom));

        };
    }
}
