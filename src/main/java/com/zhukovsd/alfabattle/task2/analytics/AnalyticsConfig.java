package com.zhukovsd.alfabattle.task2.analytics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnalyticsConfig {

    @Bean
    public UsersAnalytics analytics() {
        return new UsersAnalytics();
    }

}
