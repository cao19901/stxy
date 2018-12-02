package com.bootdo.clouddoadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients(basePackages = {"com.bootdo"})
@EnableCaching
@EnableScheduling
@MapperScan(basePackages = "com.bootdo.clouddoadmin.dao")
@SpringBootApplication(scanBasePackages = {"com.bootdo.clouddoadmin", "com.bootdo.clouddocommon"})
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@EnableTransactionManagement // 开始事务 , 分布式事务
public class ClouddoAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClouddoAdminApplication.class, args);
    }

}
