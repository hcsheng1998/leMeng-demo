package com.nhsoft.ledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author hcsheng1998
 */
@SpringBootApplication
@EnableJpaRepositories
public class LedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LedemoApplication.class, args);
    }

}
