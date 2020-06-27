package com.zhukovsd.alfabattle.task2.analytics;

import com.zhukovsd.alfabattle.task2.analytics.stats.UserAnalyticsStats;
import com.zhukovsd.alfabattle.task2.analytics.stats.UsersAnalyticsStats;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnalyticsConfig {

    @Bean
    public UsersAnalytics analytics() {
        return new UsersAnalytics();
    }

    @Bean
    public UsersAnalyticsStats stats() {
        return new UsersAnalyticsStats();
    }

}
