package com.zhukovsd.alfabattle.task2.analytics;

import com.zhukovsd.alfabattle.task2.payments.model.Payment;

import java.util.HashMap;

// key - user id, value - analytics for one user
public class UsersAnalytics extends HashMap<String, UserAnalytics> {

    public void processPayment(Payment payment) {
        String userId = payment.getUserId();

        if (!this.containsKey(userId)) {
            this.put(userId, new UserAnalytics(userId));
        }

        UserAnalytics userAnalytics = this.get(userId);
        userAnalytics.processPayment(payment);
    }

}
