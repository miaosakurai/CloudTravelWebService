package com.cloudtravel.cloudtravelwebservice.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.cloudtravel.cloudtravelwebservice.mapper")
@EnableTransactionManagement
public class PersistenceConfig {

}