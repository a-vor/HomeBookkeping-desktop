package com.company;

public class Operations {
    public int id, categoryId, scoreId;
    public int money;
    public String rewiev;

    public Operations(int id, int categoryId, int scoreId, int money, String rewiev) {
        this.id = id;
        this.categoryId = categoryId;
        this.scoreId = scoreId;
        this.money = money;
        this.rewiev = rewiev;
    }

    public Operations(int categoryId, int scoreId, int money, String rewiev) {
        this.id = id;
        this.categoryId = categoryId;
        this.scoreId = scoreId;
        this.money = money;
        this.rewiev = rewiev;
    }

    @Override
    public String toString() {
        return "Operations{" +
                "id=" + this.id +
                ", categoryId=" + this.categoryId +
                ", scoreId=" + this.scoreId +
                ", money=" + this.money +
                ", rewiev=" + this.rewiev +
                '}';
    }
}
