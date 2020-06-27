package com.zhukovsd.alfabattle.task2.analytics.stats;

import com.zhukovsd.alfabattle.task2.analytics.UserAnalytics;
import com.zhukovsd.alfabattle.task2.analytics.UsersAnalytics;

import java.util.HashMap;
import java.util.Map;

public class UsersAnalyticsStats extends HashMap<String, UserAnalyticsStats> {

    public void recalcStats(UsersAnalytics analytics) {
        this.clear();

        for(Map.Entry<String, UserAnalytics> entry : analytics.entrySet()) {
            String userId = entry.getKey();
            UserAnalytics userAnalytics = entry.getValue();

            this.put(userId, new UserAnalyticsStats(userAnalytics));
        }
    }

}
