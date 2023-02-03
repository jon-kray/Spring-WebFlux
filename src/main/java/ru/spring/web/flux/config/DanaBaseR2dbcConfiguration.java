package ru.spring.web.flux.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DanaBaseR2dbcConfiguration {

    public ConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
                .port(5432)
                .host("localhost")
                .username("postgres")
                .password("0000")
                .database("postgres")
                .build());
    }

}
