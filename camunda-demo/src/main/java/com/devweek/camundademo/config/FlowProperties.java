package com.devweek.camundademo.config;

import lombok.*;
import org.springframework.boot.context.properties.*;
import org.springframework.context.annotation.*;

@Data
@Configuration
@ConfigurationProperties(prefix = "camunda")
public class FlowProperties {
    private Db db;

    @Data
    public static class Db {
        private String url;
        private String username;
        private String password;
        private String driverClassName;
    }
}
