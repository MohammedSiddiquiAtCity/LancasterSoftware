package org.redsox.lancastersfx.core;

public class Delivery {

    private Kitchen kitchen;
    private int date;

    public Delivery(Kitchen kitchen, int date) {
        this.kitchen = kitchen;
        this.date = date;
    }

    public void addIngredient(){

    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
