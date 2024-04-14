package org.redsox.lancastersfx.core;

public class Recipe {
    // Class variables
    private int id;
    private String name;
    private String description;
    private int creatorID;
    private boolean approved = false;

    public Recipe(String name, int creatorID) {
        this.name = name;
        this.creatorID = creatorID;
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
}
