package com.zhukovsd.alfabattle.task2.analytics;

import com.zhukovsd.alfabattle.task2.payments.model.Payment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.HashMap;

// key - category id, value - payments list
public class UserAnalytics {

    public String userId;
    public BigDecimal totalSum = new BigDecimal(0);
    public UserAnalyticInfo analyticInfo = new UserAnalyticInfo();

    public UserAnalytics(String userId) {
        this.userId = userId;
    }

    public void processPayment(Payment payment) {
        this.analyticInfo.processPayment(payment);

        this.recalcTotalSum();
    }

    private void recalcTotalSum() {
         BigDecimal totalSum = this.analyticInfo.values().stream().map(userPaymentList -> userPaymentList.sum)
                .reduce(new BigDecimal(0), BigDecimal::add);

         this.totalSum = totalSum.setScale(2, RoundingMode.HALF_EVEN);
    }
}
