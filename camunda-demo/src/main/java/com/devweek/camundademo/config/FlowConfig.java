package com.devweek.camundademo.config;

import lombok.*;
import org.camunda.bpm.dmn.engine.*;
import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.spring.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.*;
import org.springframework.jdbc.datasource.*;
import org.springframework.transaction.*;

import javax.sql.*;

@Configuration
@AllArgsConstructor
public class FlowConfig {
    private FlowProperties flowProperties;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(flowProperties.getDb().getDriverClassName());
        dataSource.setUrl(flowProperties.getDb().getUrl());
        dataSource.setUsername(flowProperties.getDb().getUsername());
        dataSource.setPassword(flowProperties.getDb().getPassword());
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SpringProcessEngineConfiguration engineConfiguration(
            DataSource dataSource,
            PlatformTransactionManager transactionManager,
            @Value("classpath*:flows/**/*.*mn") Resource[] deploymentResources) {
        SpringProcessEngineConfiguration configuration = new SpringProcessEngineConfiguration();
        configuration.setDataSource(dataSource);
        configuration.setTransactionManager(transactionManager);
        configuration.setDatabaseSchemaUpdate("true");
        configuration.setJobExecutorActivate(true);
        configuration.setDeploymentResources(deploymentResources);
        return configuration;
    }

    @Bean
    public ProcessEngineFactoryBean engineFactory(SpringProcessEngineConfiguration engineConfiguration) {
        ProcessEngineFactoryBean factoryBean = new ProcessEngineFactoryBean();
        factoryBean.setProcessEngineConfiguration(engineConfiguration);
        return factoryBean;
    }

    @Bean
    public ProcessEngine processEngine(ProcessEngineFactoryBean factoryBean) throws Exception {
        return factoryBean.getObject();
    }

    @Bean
    public RuntimeService runtimeService(ProcessEngine processEngine) {
        return processEngine.getRuntimeService();
    }
}
