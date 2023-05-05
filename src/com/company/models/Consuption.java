package com.company.models;

public class Consuption extends Operations {

    public Consuption(int id, int categoryId, int scoreId, int money, String rewiev){
        super(id, categoryId, scoreId, money, rewiev);
    }

    public Consuption(int categoryId, int scoreId, int money, String rewiev){
        super(categoryId, scoreId, money, rewiev);
    }
}
