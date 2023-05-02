package com.company.models;

public class Score {
    private int id, sum, userId;

    private String title;

    public Score(int id, int sum, int userId, String title) {
        this.id = id;
        this.sum = sum;
        this.userId = userId;
        this.title = title;
    }

    public Score(int sum, int userId, String title) {
        this.sum = sum;
        this.userId = userId;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getSum() {
        return sum;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
