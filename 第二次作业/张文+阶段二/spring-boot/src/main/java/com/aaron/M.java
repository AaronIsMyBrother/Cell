package com.aaron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

@SpringBootApplication
public class M {

    public static void main(String[] args) {
        SpringApplication.run(M.class,args);
    }
}
