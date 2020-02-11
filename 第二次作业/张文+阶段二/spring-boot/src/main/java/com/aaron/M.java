package com.aaron;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.aaron.dao")
@SpringBootApplication
public class M {

    public static void main(String[] args) {
        SpringApplication.run(M.class,args);
    }
}
