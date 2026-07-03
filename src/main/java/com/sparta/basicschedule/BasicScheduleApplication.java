package com.sparta.basicschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BasicScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicScheduleApplication.class, args);
    }

}
