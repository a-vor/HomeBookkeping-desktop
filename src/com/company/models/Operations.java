package com.company.models;

import java.util.Date;

public class Operations {
    protected int id, categoryId, scoreId;

    protected Date date;
    protected int money;
    protected String review;

    public Operations(int categoryId, int scoreId, Date date, int money, String review) {
        this.categoryId = categoryId;
        this.scoreId = scoreId;
        this.date = date;
        this.money = money;
        this.review = review;
    }

    public Operations(int id, int categoryId, int scoreId, Date date, int money, String review) {
        this.id = id;
        this.categoryId = categoryId;
        this.scoreId = scoreId;
        this.date = date;
        this.money = money;
        this.review = review;
    }

    @Override
    public String toString() {
        return "Operations{" +
                "id=" + this.id +
                ", categoryId=" + this.categoryId +
                ", scoreId=" + this.scoreId +
                ", money=" + this.money +
                ", review=" + this.review +
                '}';
    }
}
