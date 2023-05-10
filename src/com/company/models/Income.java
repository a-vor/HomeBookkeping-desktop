package com.company.models;

import java.util.Date;

public class Income extends Operations {

    public Income(int categoryId, int scoreId, Date date, int money, String review){
        super(categoryId, scoreId, date, money, review);
    }

    public Income(int id, int categoryId, int scoreId, Date date, int money, String review) {
        super(id, categoryId, scoreId, date, money, review);
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", scoreId=" + scoreId +
                ", date=" + date +
                ", money=" + money +
                ", review='" + review + '\'' +
                '}';
    }
}
