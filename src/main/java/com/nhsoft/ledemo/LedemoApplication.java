package com.nhsoft.ledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author 中意你
 */
@SpringBootApplication
@EnableJpaRepositories
public class LedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LedemoApplication.class, args);
    }

}
