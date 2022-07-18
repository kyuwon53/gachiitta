package com.gachi.itta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class IttaApplication {

    public static void main(String[] args) {
        SpringApplication.run(IttaApplication.class, args);
    }

}
