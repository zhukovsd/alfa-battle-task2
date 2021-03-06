package com.zhukovsd.alfabattle.task2.analytics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhukovsd.alfabattle.task2.payments.model.Payment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@JsonIgnoreProperties(value = { "list" })
public class UserPaymentList {

    public BigDecimal min = new BigDecimal(0);
    public BigDecimal max = new BigDecimal(0);
    public BigDecimal sum = new BigDecimal(0);

    public List<Payment> list = new ArrayList<>();

    public void processPayment(Payment payment) {
        this.list.add(payment);

        this.recalcMin();
        this.recalcMax();
        this.recalcSum();
    }

    private void recalcMin() {
        Optional<BigDecimal> optional = this.list.stream().min(Comparator.comparing(Payment::getAmount)).map(Payment::getAmount);
        BigDecimal min = optional.orElse(new BigDecimal(0));

        this.min = min.setScale(2, RoundingMode.HALF_EVEN);
    }

    private void recalcMax() {
        Optional<BigDecimal> optional = this.list.stream().max(Comparator.comparing(Payment::getAmount)).map(Payment::getAmount);
        BigDecimal max = optional.orElse(new BigDecimal(0));

        this.max = max.setScale(2, RoundingMode.HALF_EVEN);
}

    private void recalcSum() {
        BigDecimal sum = this.list.stream().map(Payment::getAmount).reduce(new BigDecimal(0), BigDecimal::add);

        this.sum = sum.setScale(2, RoundingMode.HALF_EVEN);
    }

}
