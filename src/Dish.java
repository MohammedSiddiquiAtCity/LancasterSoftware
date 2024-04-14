package src;

import java.util.List;

public class Dish {
    private String name;
    private String description;
    private List<Recipe> recipes;

    // Constructor
    public Dish(String name, String description, List<Recipe> recipes) {
        this.name = name;
        this.description = description;
        this.recipes= recipes;
    }

    //Need API functionality here so that we can
    //retrieve everything from the website.
    //may need to consider changing this to return something else like a String[]
    public String viewFeedback(){
        return "";
    }

    // Getters and setters
    // You can generate them using your IDE or manually implement them
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void addRecipe(Recipe recipe){
        recipes.add(recipe);
    }

    // Optional: Override toString() method for better readability
    @Override
    public String toString() {


        return "Dish{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", Recipes=" + "NEED TO ADD LIST FUNCTIONALITY HERE FOR MAKING THE " +
                '}';
    }
}
