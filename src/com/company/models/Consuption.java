package com.company.models;

import java.util.Date;

public class Consuption extends Operations {

    public Consuption(int categoryId, int scoreId, Date date, int money, String review) {
        super(categoryId, scoreId, date, money, review);
    }

    public Consuption(int id, int categoryId, int scoreId, Date date, int money, String review) {
        super(id, categoryId, scoreId, date, money, review);
    }
}
