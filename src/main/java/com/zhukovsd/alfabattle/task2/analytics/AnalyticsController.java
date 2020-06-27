package com.zhukovsd.alfabattle.task2.analytics;

import com.zhukovsd.alfabattle.task2.analytics.stats.UserAnalyticsStats;
import com.zhukovsd.alfabattle.task2.analytics.stats.UsersAnalyticsStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnalyticsController {

    @Autowired
    UsersAnalytics analytics;

    @Autowired
    UsersAnalyticsStats stats;

    @GetMapping(value = "analytic")
    public List<UserAnalytics> getAnalytic() {
        return new ArrayList<>(analytics.values());
    }

    @GetMapping(value = "analytic/{userId}")
    public UserAnalytics getUserAnalytic(@PathVariable("userId") String userId) {
        if (!analytics.containsKey(userId)) {
            throw new UserNotFoundException();
        }

        return analytics.get(userId);
    }

    @GetMapping(value = "analytic/{userId}/stats")
    public UserAnalyticsStats getUserAnalyticStats(@PathVariable("userId") String userId) {
        if (!stats.containsKey(userId)) {
            throw new UserNotFoundException();
        }

        return stats.get(userId);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ErrorJsonResponse> handleException(Exception e) {
        return new ResponseEntity<ErrorJsonResponse>(new ErrorJsonResponse("user not found"), HttpStatus.NOT_FOUND);
    }


}
