package com.cisco;

import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * Tests the team order
 */
public class TeamOrderTest {
    /**
     * Process the team order
     *
     * @throws Exception if there is an error
     */
    @org.junit.Test
    public void processTeamOrder() throws Exception {

        // setup the team members
        TeamMember teamMember1 = new TeamMember("Keith Balante", DietRestriction.VEGAN);
        TeamMember teamMember2 = new TeamMember("John Esquires", DietRestriction.PEANUT_FREE);
        TeamMember teamMember3 = new TeamMember("Kevin Quan", DietRestriction.NONE);
        TeamMember teamMember4 = new TeamMember("Dude", DietRestriction.ABC);
        ArrayList<TeamMember> teamMembers = new ArrayList<TeamMember>();
        teamMembers.add(teamMember1);
        teamMembers.add(teamMember2);
        teamMembers.add(teamMember3);
        teamMembers.add(teamMember4);

        // setup a couple restaurants
        Restaurant restaurant1 = new Restaurant("Deluxe Diner", 3);
        Restaurant restaurant2 = new Restaurant("Viet Pho", 4);
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        restaurants.add(restaurant1);
        restaurants.add(restaurant2);

        // give restaurant 1 some meals
        ArrayList<Meal> meals1  = new ArrayList();
        Meal mealA = new Meal("Brocoli with ketchup", DietRestriction.VEGAN);
        Meal mealB = new Meal("Fettucini Alfredo", DietRestriction.NONE);
        meals1.add(mealA);
        meals1.add(mealB);
        restaurant1.setMeals(meals1);

        // give restaurant 2 some meals
        ArrayList<Meal> meals2  = new ArrayList();
        Meal mealC = new Meal("Brocoli with ketchup", DietRestriction.VEGAN);
        Meal mealD = new Meal("farm fresh eggs & ham", DietRestriction.PEANUT_FREE);
        Meal mealE = new Meal("Spaghetti", DietRestriction.NONE);
        meals2.add(mealC);
        meals2.add(mealD);
        meals2.add(mealE);
        restaurant2.setMeals(meals2);

        // create a team order by setting the restaurants to choose from and the team members who want lunch
        TeamOrder teamOrder = new TeamOrder();
        teamOrder.setRestaurants(restaurants);
        teamOrder.setTeamMembers(teamMembers);
        teamOrder.processTeamOrder();

        // Dude did not get a meal so out  of luck as there was no restaurant that could serve his dietary restrictions
        assertTrue(teamMember1.hasMeal());
        assertTrue(teamMember2.hasMeal());
        assertTrue(teamMember3.hasMeal());
        assertFalse(teamMember4.hasMeal());

        // expecting broccoli and fettucini
        ArrayList<Meal> expected = new ArrayList<Meal>();
        expected.add(mealA);
        expected.add(mealB);

        // restaurant1 i.e. deluxe diner should still have all their meals
        assertThat(restaurant1.getMeals(), is(expected));
    }

}