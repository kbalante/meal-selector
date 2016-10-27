package com.cisco;

/**
 * A team member that loves to eat, but may be a little picky.
 */
public class TeamMember {
    private String name;
    private Meal meal;
    private String dietRestriction;

    public TeamMember(String name, Meal meal, String dietRestriction) {
        this.name = name;
        this.meal = meal;
        this.dietRestriction = dietRestriction;
    }

    public TeamMember(String name, String dietRestriction) {
        this.name = name;
        this.dietRestriction = dietRestriction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public String getDietRestriction() {
        return dietRestriction;
    }

    public void setDietRestriction(String dietRestriction) {
        this.dietRestriction = dietRestriction;
    }

    /**
     * Check if the team member got his or her order
     * @return true if the team member has been served a meal
     */
    public boolean hasMeal() {
        if (getMeal()!=null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "TeamMember{" +
                "name='" + name + '\'' +
                ", meal=" + meal +
                ", dietRestriction='" + dietRestriction + '\'' +
                '}';
    }
}
