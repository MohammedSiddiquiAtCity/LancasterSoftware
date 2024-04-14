package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface IMngmtKit {

    Menu getCurrentMenu();

    class Menu{
        protected List<Dish> dishes;
        public Menu(List<Dish> dishes) {
            this.dishes = dishes;
        }
        public Set<Ingredient> getAllIngredients(){
            Set<Ingredient> ingredients = new HashSet<>();
            for(Dish dish : dishes){
                ingredients.addAll(dish.getIngredients());
            }
            return ingredients;
        }
        public List<String> getDishNames(){
            ArrayList<String> dishNames = new ArrayList<>();
            for(Dish dish : dishes){
                dishNames.add(dish.getName());
            }
            return dishNames;
        }
    }

    class Dish{
        protected String name;
        protected List<Ingredient> ingredients;

        public Dish(String name, List<Ingredient> ingredients) {
            this.name = name;
            this.ingredients = ingredients;
        }

        public String getName() {
            return name;
        }

        public List<Ingredient> getIngredients() {
            return ingredients;
        }

    }
    class Ingredient{

        protected String name;
        protected int id;
        Ingredient(String name){
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
