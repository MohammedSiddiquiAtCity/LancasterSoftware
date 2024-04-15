package org.redsox.lancastersfx.core;

public class Chef {
    private int id;
    private String name;
    private Kitchen kitchen;

    public Chef(int id, String name, Kitchen kitchen) {
        this.id = id;
        this.name = name;
        this.kitchen = kitchen;
    }

    public void addIngredient(String name, int quantity){
        kitchen.addStock(name, quantity);
    }

    public void removeIngredient(String name, int quantity){
        kitchen.removeStock(name, quantity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
}
