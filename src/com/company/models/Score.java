package com.company.models;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class Score {
    private int id, userId;
    double  sum;

    private String title;

    public Score(int id, double sum, int userId, String title) {
        this.id = id;
        this.sum = sum;
        this.userId = userId;
        this.title = title;
    }

    public Score(double sum, int userId, String title) {
        this.sum = sum;
        this.userId = userId;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public double getSum() {
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

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
