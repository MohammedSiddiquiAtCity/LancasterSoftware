package org.redsox.lancastersfx.core;

public class Chef {
    private String id;
    private String name;
    private String email;
    private Kitchen kitchen;

    public Chef(String id, String name, String email, Kitchen kitchen) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.kitchen = kitchen;
    }

    public void addIngredient(String name, int quantity){
        kitchen.addStock(name, quantity);
    }

    public void removeIngredient(String name, int quantity){
        kitchen.removeStock(name, quantity);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
}
