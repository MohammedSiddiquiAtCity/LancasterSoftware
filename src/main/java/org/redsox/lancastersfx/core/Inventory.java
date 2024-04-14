package org.redsox.lancastersfx.core;

import java.util.Vector;


public class Inventory {
    private Vector<Ingredient> ingredients = new Vector<>();

    //TODO: need to shift all the SQL queries to its own class
    // then create SQL connectivity subclasses for each of the necessary classes.
    public Inventory() {

    }

    public void addStock(String itemName, int quantity) {
        //Use the DB connection to update the value in the DB.
    }
    public void removeStock(String itemName, int Quantity){
        //Use the DB connection to update the value in the DB.
    }

    public void addIngredient(String itemName){
        //Use the DB connection to add the ingredient in the DB.
    }

    public void removeIngredient(String itemName){
        //Use the DB connection to add the ingredient in the DB.
    }

}
