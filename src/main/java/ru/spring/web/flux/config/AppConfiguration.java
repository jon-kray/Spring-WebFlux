package ru.spring.web.flux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class AppConfiguration {

    @Bean
    @Primary
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(12);
    }
}
