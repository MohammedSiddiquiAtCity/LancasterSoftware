package org.redsox.lancastersfx.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recipe {
    // Class variables
    private int id;
    private String name;
    private String description;
    private int creatorID;
    private boolean approved = false;

    private List<Ingredient> ingredient = new ArrayList<>();

    public Recipe(String name, int creatorID) {
        this.name = name;
        this.creatorID = creatorID;
        //this.ingredient = ingredient;
    }
    // Method to get approval for the recipe
    public boolean isApproved() {
        return approved;
    }

    // Method to set a review for the recipe (currently seems to have infinite recursion)
    public String setReview() {
        return "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter methods for class variables
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public List<Ingredient> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<Ingredient> ingredient) {
        this.ingredient = ingredient;
    }

}
