package com.bilgeadam.oop.polymorphism.foods;

public class Chef {

    public Meal requestMeal(String meal){
        Meal food = switch (MealTypes.valueOf(meal)){
            case Pizza -> MealTypes.Pizza.getMeal();
            case Hamburger -> MealTypes.Hamburger.getMeal();
        };
        return prepareMeal(food);
    }
    private Meal prepareMeal(Meal meal){
        System.out.println("Food will be ready in" + meal.getPreparationTime());

        return meal;
    }
}

    //enum'lar memory'de tek bir sefer yaratılır. her seferinde memory'de yeni bir obje yaratılmaz.

enum MealTypes{
    Hamburger(new Hamburger("Beef", 7L)),
    Pizza(new Pizza("Test", 12.6F));

    private final Meal meal;

    MealTypes(Meal meal) {
        this.meal = meal;
    }

    public Meal getMeal() {
        return meal;
    }
}