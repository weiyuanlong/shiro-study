package com.naka.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.naka.test.mapper")
public class ComNakaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComNakaTestApplication.class, args);
    }

}
