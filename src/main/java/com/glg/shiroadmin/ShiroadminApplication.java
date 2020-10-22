package com.glg.shiroadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.glg.shiroadmin.mapper")
public class ShiroadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroadminApplication.class, args);
    }

}
