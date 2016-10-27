package com.cisco;

import java.util.ArrayList;

/**
 * A restaurant with a rating and a list of meals it can serve
 */
public class Restaurant {
    private String name;
    private int rating;
    private ArrayList<Meal> meals;

    public Restaurant(String name, int rating, ArrayList<Meal> meals) {
        this.name = name;
        this.rating = rating;
        this.meals = meals;
    }

    public Restaurant(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Prepare a bunch of meals.
     * @param meals the collection of meals to prepare each with their own dietary restrictions if any
     */
    public void setMeals(ArrayList<Meal> meals) {
        //Collections.sort(meals, new MealComparatorByDietRestriction());
        this.meals = meals;
    }

    /**
     * Get a meal with the desired dietary restriction if any. Remove the meal from the meals if the proper meal is
     * available.
     * @param teamMember team member who wants to order a meal
     * @return true if the meal ordered is available
     */
    public boolean getMeal(TeamMember teamMember) {
        String dietaryRestriction = teamMember.getDietRestriction();
        for(Meal meal: getMeals()) {
            // if we found a meal with the desired dietary restriction from the team member, we return true and
            // remove it from the meals leftover; we also assign the meal to the team member
            if (meal.getDietRestriction().equals(dietaryRestriction)) {
                teamMember.setMeal(meal);
                getMeals().remove(meal);
                return true;
            }
        }

        return false;
    }

    /**
     * Serve the meals that are requested up to the maximum available the restaurant has prepared
     * @param teamMembers the team members with the order request. All team members that have been served are
     *                    removed from this list
     */
    public void orderMeals(ArrayList<TeamMember> teamMembers) {
        // iterate over each requested meal and see if the restaurant can serve it
        // if it can, then add it to the list of meals served
        ArrayList<TeamMember> teamMembersServed = new ArrayList();

        // iterate over each team member to process meal requested
        for (TeamMember teamMember:teamMembers) {
            // get the meal if available
            if (getMeal(teamMember)) {
                // success
                teamMembersServed.add(teamMember);
            }
        }

        // remove the team members that have been served
        teamMembers.removeAll(teamMembersServed);
    }

    /**
     * Get the list of meals remaining.
     * @return the list of meals remaining.
     */
    public ArrayList<Meal> getMeals() {
        return this.meals;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", meals=" + meals +
                '}';
    }
}
