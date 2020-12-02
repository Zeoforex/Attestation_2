package com.dibirov.dibirov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DibirovApplication {

    public static void main(String[] args) {
        SpringApplication.run(DibirovApplication.class, args);
    }

}
