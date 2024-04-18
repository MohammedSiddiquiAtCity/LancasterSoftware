package org.redsox.lancastersfx.core;

/**
 * The Recipe class represents a recipe in a restaurant.
 * It contains information about the recipe ID, name, description, creator ID, and approval status.
 */
public class Recipe {

    /** The unique identifier of the recipe. */
    private int id;

    /** The name of the recipe. */
    private String name;

    /** The description of the recipe. */
    private String description;

    /** The ID of the creator of the recipe. */
    private int creatorID;

    /** The approval status of the recipe. */
    private boolean approved = false;

    /**
     * Constructs a Recipe object with the specified name and creator ID.
     *
     * @param name the name of the recipe
     * @param creatorID the ID of the creator of the recipe
     */
    public Recipe(String name, int creatorID) {
        this.name = name;
        this.creatorID = creatorID;
    }

    /**
     * Returns whether the recipe is approved or not.
     *
     * @return true if the recipe is approved, false otherwise
     */
    public boolean isApproved() {
        return approved;
    }

    /**
     * Sets the approval status of the recipe.
     *
     * @param approved the new approval status of the recipe
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    /**
     * Returns the name of the recipe.
     *
     * @return the name of the recipe
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the recipe.
     *
     * @param name the new name of the recipe
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the unique identifier of the recipe.
     *
     * @return the unique identifier of the recipe
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the recipe.
     *
     * @param id the new unique identifier of the recipe
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the description of the recipe.
     *
     * @return the description of the recipe
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the recipe.
     *
     * @param description the new description of the recipe
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the ID of the creator of the recipe.
     *
     * @return the ID of the creator of the recipe
     */
    public int getCreatorID() {
        return creatorID;
    }

    /**
     * Sets the ID of the creator of the recipe.
     *
     * @param creatorID the new ID of the creator of the recipe
     */
    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }
}
