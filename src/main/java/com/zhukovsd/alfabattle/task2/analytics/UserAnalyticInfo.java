package com.zhukovsd.alfabattle.task2.analytics;

import com.zhukovsd.alfabattle.task2.payments.model.Payment;

import java.util.HashMap;

public class UserAnalyticInfo extends HashMap<String, UserPaymentList> {

    public void processPayment(Payment payment) {
        int categoryId = payment.getCategoryId();

        String key = String.valueOf(categoryId);
        if (!this.containsKey(key)) {
            this.put(key, new UserPaymentList());
        }

        UserPaymentList payments = this.get(key);
        payments.processPayment(payment);
    }

}
