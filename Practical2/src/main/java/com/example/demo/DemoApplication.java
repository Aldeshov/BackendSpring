package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("DATABASE_URL : " + System.getenv("JDBC_DATABASE_URL"));
        SpringApplication.run(DemoApplication.class, args);
    }

}
