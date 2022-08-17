package com.ycj.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ycj.order.mapper")
public class OrderServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
