package com.best0167.lol.lolcustomrecord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LolCustomRecordApplication {

    public static void main(String[] args) {

        SpringApplication.run(LolCustomRecordApplication.class, args);
    }

}
