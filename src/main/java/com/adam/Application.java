package com.adam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by wangwei on 2016/9/2.
 */
@ComponentScan(basePackages = {"com.adam.mapper.Controller"})
@MapperScan(basePackages = "com.adam.mapper.Mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}