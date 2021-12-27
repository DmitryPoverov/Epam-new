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

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public boolean getAvailable() {
        return available;
    }
    public MealType getMealType() {
        return mealType;
    }

    @Override
    public String toString() {
        return "\t\t\t[MealsIncluded: \n" +
                "\t\t\tavailable = " + available + ", \n" +
                "\t\t\tmealType = " + mealType + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MealsIncluded that = (MealsIncluded) o;

        if (available != that.available) return false;
        return mealType == that.mealType;
    }

    @Override
    public int hashCode() {
        int result = (available ? 1 : 0);
        result = 31 * result + mealType.hashCode();
        return result;
    }
}
