package com.epam.xmlXsdTask.entities.associatedClasses;

import com.epam.xmlXsdTask.entities.associatedClasses.enums.MealType;

public class MealsIncluded {
    private boolean available;
    private MealType mealType;

    public MealsIncluded() {
    }

    public MealsIncluded(boolean available, MealType mealType) {
        this.available = available;
        this.mealType = mealType;
    }

    public boolean isAvailable() {
        return available;
    }
    public MealType getMealType() {
        return mealType;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    @Override
    public String toString() {
        return "		[MealsIncludedData: \n" +
                "		available=" + available + ", \n" +
                "		mealType=" + mealType + "]";
    }
}
