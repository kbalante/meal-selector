package com.cisco;

/**
 * A meal that meets a dietary restriction if any.
 */
public class Meal {
    String name;

    /**
     * An empty diet restriction means it does not meet any diet restrictions.
     */
    String dietRestriction = "";

    public Meal(String name, String dietRestriction) {
        this.name = name;
        this.dietRestriction = dietRestriction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDietRestriction() {
        return dietRestriction;
    }

    public void setDietRestriction(String dietRestriction) {
        this.dietRestriction = dietRestriction;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "name='" + name + '\'' +
                ", dietRestriction='" + dietRestriction + '\'' +
                '}';
    }
}
