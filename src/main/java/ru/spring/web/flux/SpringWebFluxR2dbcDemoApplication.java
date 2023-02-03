package ru.spring.web.flux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringWebFluxR2dbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebFluxR2dbcDemoApplication.class, args);
    }

}
