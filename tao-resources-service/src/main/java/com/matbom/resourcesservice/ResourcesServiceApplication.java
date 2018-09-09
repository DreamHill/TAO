package com.matbom.resourcesservice;

import com.matbom.utils.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableAsync
@ComponentScan
@EnableConfigurationProperties
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.matbom.resourcesservice.dao")
@SpringBootApplication
public class ResourcesServiceApplication {
    //spring security加密对象
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //主键生成对象
    @Bean
    public IdWorker idWorker() {
        return  new IdWorker(3);
    }
    public static void main(String[] args) {
        SpringApplication.run(ResourcesServiceApplication.class, args);
    }
}
