package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.study.mapper")
public class RunApp {
    public static void main(String[] args) {
        SpringApplication.run(RunApp.class,args);
    }
}
