package com.zhukovsd.alfabattle.task2.analytics.templates;

import java.math.BigDecimal;

public class Template {

    private int categoryId;
    private String recipientId;
    private BigDecimal amount;

    public Template() {
    }

    public Template(int categoryId, String recipientId, BigDecimal amount) {
        this.categoryId = categoryId;
        this.recipientId = recipientId;
        this.amount = amount;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
