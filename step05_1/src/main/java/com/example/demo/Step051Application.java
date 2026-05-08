package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.demo.repository")
public class Step051Application {

    public static void main(String[] args) {
        SpringApplication.run(Step051Application.class, args);
    }
}