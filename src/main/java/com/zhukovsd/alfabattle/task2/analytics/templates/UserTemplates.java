package com.zhukovsd.alfabattle.task2.analytics.templates;

import com.zhukovsd.alfabattle.task2.analytics.UserAnalytics;
import com.zhukovsd.alfabattle.task2.analytics.UserPaymentList;
import com.zhukovsd.alfabattle.task2.payments.model.Payment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserTemplates extends ArrayList<Template> {

    public UserTemplates(UserAnalytics userAnalytics) {
        List<Payment> paymentsForAllCategories = userAnalytics.analyticInfo.values().stream()
                .flatMap(userPaymentList -> userPaymentList.list.stream()).collect(Collectors.toList());

//        paymentsForAllCategories = Arrays.asList(
//                new Payment(1, "1", "2", "123", 1d),
//                new Payment(1, "1", "2", "123", 1d)
//        );

        Map<Payment, Long> occurrencesByPayments = paymentsForAllCategories.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Template> templates = occurrencesByPayments.entrySet().stream().filter(paymentLongEntry -> paymentLongEntry.getValue() >= 3)
                .map(Map.Entry::getKey)
                .map(payment -> new Template(payment.getCategoryId(), payment.getRecipientId(), payment.getAmount()))
                .collect(Collectors.toList());

        this.addAll(templates);

//                .occurancesByPayments(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    }

}
