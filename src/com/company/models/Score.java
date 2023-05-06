package com.company.models;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class Score {
    ArrayList<Object[]> resultList;
    ArrayList<String> columnNames;
    private int id, userId;
    double  sum;

    private String title;

    public Score(ResultSet resultSet, ResultSetMetaData metaData) {
        int columnCount = 0;
        try {
            columnCount = metaData.getColumnCount();
            for (int i = 0; i < columnCount; i++)
                columnNames.add(metaData.getColumnLabel(i+1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                resultList.add(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

    public ArrayList<Object[]> getResultList() {
        return resultList;
    }

    public ArrayList<String> getColumnNames() {
        return columnNames;
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
