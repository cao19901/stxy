package com.bootdo.clouddocms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = {"com.bootdo.*.dao"})
public class ClouddoCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClouddoCmsApplication.class, args);
    }

}
