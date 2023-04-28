package com.company.models;

import com.company.Operations;

public class Income extends Operations {

    public Income(int id, int categoryId, int scoreId, int money, String rewiev){
        super(id, categoryId, scoreId, money, rewiev);
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", scoreId=" + scoreId +
                ", money=" + money +
                ", rewiev='" + rewiev + '\'' +
                '}';
    }
}
