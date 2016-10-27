package com.cisco;

import com.cisco.sort.RestaurantComparatorByRating;
import com.cisco.sort.TeamMemberComparatorByDietRestriction;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Process the team order using assigned team members and restaurants.
 */
public class TeamOrder {

    /**
     * team members wanting some lunch
     */
    ArrayList<TeamMember> teamMembers;

    /**
     * restaurants that will be providing the meals
     */
    ArrayList<Restaurant> restaurants;

    public ArrayList<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(ArrayList<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    /**
     * Process the team order. The restaurants can only fulfill what they have available.
     */
    public void processTeamOrder() {
        // sort the restaurants by rating
        Collections.sort(restaurants, new RestaurantComparatorByRating());

        // sort the team members so that the ones with the diet restrictions are served first if possible
        Collections.sort(teamMembers, new TeamMemberComparatorByDietRestriction());

        for (Restaurant restaurant: restaurants) {
            // for each restaurant order meals for the team members who have not gotten a meal yet
            restaurant.orderMeals(teamMembers);
        }
    }
}