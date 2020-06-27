package com.zhukovsd.alfabattle.task2.analytics.stats;

import com.zhukovsd.alfabattle.task2.analytics.UserAnalytics;
import com.zhukovsd.alfabattle.task2.payments.model.Payment;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class UserAnalyticsStats {

    private int oftenCategoryId;
    private int rareCategoryId;

    private int maxAmountCategoryId;
    private int minAmountCategoryId;

    public UserAnalyticsStats() {
    }

    public UserAnalyticsStats(int oftenCategoryId, int rareCategoryId, int maxAmountCategoryId, int minAmountCategoryId) {
        this.oftenCategoryId = oftenCategoryId;
        this.rareCategoryId = rareCategoryId;
        this.maxAmountCategoryId = maxAmountCategoryId;
        this.minAmountCategoryId = minAmountCategoryId;
    }

    public UserAnalyticsStats(UserAnalytics analytics) {
        calcOftenRareStats(analytics);
        calcAmountStats(analytics);
    }

    public int getOftenCategoryId() {
        return oftenCategoryId;
    }

    public void setOftenCategoryId(int oftenCategoryId) {
        this.oftenCategoryId = oftenCategoryId;
    }

    public int getRareCategoryId() {
        return rareCategoryId;
    }

    public void setRareCategoryId(int rareCategoryId) {
        this.rareCategoryId = rareCategoryId;
    }

    public int getMaxAmountCategoryId() {
        return maxAmountCategoryId;
    }

    public void setMaxAmountCategoryId(int maxAmountCategoryId) {
        this.maxAmountCategoryId = maxAmountCategoryId;
    }

    public int getMinAmountCategoryId() {
        return minAmountCategoryId;
    }

    public void setMinAmountCategoryId(int minAmountCategoryId) {
        this.minAmountCategoryId = minAmountCategoryId;
    }

    private void calcOftenRareStats(UserAnalytics analytics) {
        Map<String, Integer> countsByCategoryId = analytics.analyticInfo.entrySet().stream()
                .map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue().list.size()))
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

        String maxS = Collections.max(countsByCategoryId.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        this.oftenCategoryId = Integer.parseInt(maxS);

        String minS = Collections.min(countsByCategoryId.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        this.rareCategoryId = Integer.parseInt(minS);
    }

    private void calcAmountStats(UserAnalytics analytics) {
        Map<String, BigDecimal> totalAmountsByCategoryId = analytics.analyticInfo.entrySet().stream()
                .map(entry -> new AbstractMap.SimpleEntry<>(
                        entry.getKey(), entry.getValue().list.stream().map(Payment::getAmount).reduce(new BigDecimal(0), BigDecimal::add)
                ))
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

        String maxAmountS = Collections.max(totalAmountsByCategoryId.entrySet(), Comparator.comparing(Map.Entry::getValue)).getKey();
        this.maxAmountCategoryId = Integer.parseInt(maxAmountS);

        String minAmountS = Collections.min(totalAmountsByCategoryId.entrySet(), Comparator.comparing(Map.Entry::getValue)).getKey();
        this.minAmountCategoryId = Integer.parseInt(minAmountS);
    }

}
