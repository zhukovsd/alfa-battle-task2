package com.zhukovsd.alfabattle.task2.payments.model;

/*

    key1:{
       "ref":"ref1",
       "categoryId":1,
       "userId":"User_1",
       "recipientId":"User_2",
       "desc":"Тестовый платеж_1",
       "amount":10.0
    }

 */

import java.math.BigDecimal;

public class Payment {

    private int categoryId;
    private String userId;
    private String recipientId;
    private String desc;
//    private double amount;
    private BigDecimal amount;

    public Payment() {
    }

    public Payment(int categoryId, String userId, String recipientId, String desc, double amount) {
        this.categoryId = categoryId;
        this.userId = userId;
        this.recipientId = recipientId;
        this.desc = desc;
        this.amount = new BigDecimal(amount);
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = new BigDecimal(amount);
    }
}
