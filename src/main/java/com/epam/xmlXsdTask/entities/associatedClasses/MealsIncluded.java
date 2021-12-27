package com.epam.xmlXsdTask.entities.associatedClasses;

import com.epam.xmlXsdTask.entities.associatedClasses.enums.MealType;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "MealsIncluded", namespace = "test")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MealsIncluded", propOrder = {"available", "mealType"})
public class MealsIncluded {
    @XmlAttribute(name = "available")
    private boolean available;
    @XmlElement(name = "mealType", namespace = "test")
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
        return "\t\t\t[MealsIncluded: \n" +
                "\t\t\tavailable = " + available + ", \n" +
                "\t\t\tmealType = " + mealType + "]";
    }
}
