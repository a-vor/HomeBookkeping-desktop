package com.company.models;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Score {
    ResultSet resultSet;
    ResultSetMetaData metaData;
    private int id, userId;
    double  sum;

    private String title;

    public Score(ResultSet resultSet, ResultSetMetaData metaData) {
        this.resultSet = resultSet;
        this.metaData = metaData;
    }

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

    public ResultSet getResultSet() {
        return resultSet;
    }

    public ResultSetMetaData getMetaData() {
        return metaData;
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
