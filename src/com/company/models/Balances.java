package com.company.models;

public class Balances {
    int id;
    int scoreId;
    double sum;

    public Balances(int id, int scoreId, double sum) {
        this.id = id;
        this.scoreId = scoreId;
        this.sum = sum;
    }

    public Balances(int scoreId, double sum) {
        this.scoreId = scoreId;
        this.sum = sum;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
