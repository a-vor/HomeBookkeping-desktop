package com.company.models;

import com.company.Operations;

public class Income extends Operations {

    public Income(int id, int categoryId, int scoreId, int money, String review){
        super(id, categoryId, scoreId, money, review);
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", scoreId=" + scoreId +
                ", money=" + money +
                ", review='" + review + '\'' +
                '}';
    }
}
