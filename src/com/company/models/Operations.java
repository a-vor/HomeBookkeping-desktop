package com.company.models;

public class Operations {
    public int id, categoryId, scoreId;
    public int money;
    public String review;

    public Operations(int id, int categoryId, int scoreId, int money, String review) {
        this.id = id;
        this.categoryId = categoryId;
        this.scoreId = scoreId;
        this.money = money;
        this.review = review;
    }

    public Operations(int categoryId, int scoreId, int money, String review) {
        this.id = id;
        this.categoryId = categoryId;
        this.scoreId = scoreId;
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
