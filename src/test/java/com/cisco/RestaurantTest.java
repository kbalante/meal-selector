package com.cisco;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests the restaurant
 */
public class RestaurantTest {

    private Restaurant restaurant;

    /**
     * Setup the meals prepared by the restaurant and setup a team member
     */
    @Before
    public void setUp() {
        restaurant = new Restaurant("Deluxe Diner", 1);

        ArrayList<Meal> meals  = new ArrayList();
        meals.add(new Meal("Brocoli with ketchup", DietRestriction.VEGAN));
        meals.add(new Meal("Shephard's Pie", DietRestriction.NONE));
        meals.add(new Meal("farm fresh eggs & ham", DietRestriction.PEANUT_FREE));
        meals.add(new Meal("Fettucini Alfredo", DietRestriction.NONE));
        meals.add(new Meal("Spaghetti", DietRestriction.NONE));

        restaurant.setMeals(meals);
    }

    /**
     * Test the fetching of a meal
     * @throws Exception if there is an error
     */
    @Test
    public void getMeal() throws Exception {

        // setup the team members that need to get a meal - Keith's the lucky one
        TeamMember teamMember1 = new TeamMember("Keith Balante", DietRestriction.VEGAN);
        TeamMember teamMember2 = new TeamMember("Elaine Balante", DietRestriction.VEGAN);

        // serve a vegan meal to the team member
        assertTrue(restaurant.getMeal(teamMember1));
        assertTrue(teamMember1.hasMeal());

        // there was only one vegan meal so should not have been served to team member 2
        // i.e. the one and only vegan meal was removed from the restaurant
        assertFalse(restaurant.getMeal(teamMember2));
        assertFalse(teamMember2.hasMeal());
    }

    /**
     * Test the ordering of meals
     * @throws Exception if there is an error
     */
    @Test
    public void orderMeals() throws Exception {
        // setup the team members that need to get a meal - Keith's the lucky one
        TeamMember teamMember1 = new TeamMember("Keith Balante", DietRestriction.VEGAN);
        TeamMember teamMember2 = new TeamMember("Elaine Balante", DietRestriction.PEANUT_FREE);
        TeamMember teamMember3 = new TeamMember("Kevin Quan", DietRestriction.NONE);
        TeamMember teamMember4 = new TeamMember("Gus Balceceres", DietRestriction.PEANUT_FREE);

        // setup team members
        ArrayList<TeamMember> teamMembers = new ArrayList<TeamMember>();
        teamMembers.add(teamMember1);
        teamMembers.add(teamMember2);
        teamMembers.add(teamMember3);
        teamMembers.add(teamMember4);

        // order meals for the team members
        // order meals for the team members
        restaurant.orderMeals(teamMembers);
        assertTrue(teamMember1.hasMeal());
        assertTrue(teamMember2.hasMeal());
        assertTrue(teamMember3.hasMeal());
        // there was only one peanut free meal so this one is false
        assertFalse(teamMember4.hasMeal());

        // 4th team member should only be the one that didn't get a meal
        // team members who got a meal should have been removed from the team member list
        ArrayList<TeamMember> expected = new ArrayList<TeamMember>();
        expected.add(teamMember4);

        // check that only the 4th team member didn't get a meal
        assertThat(teamMembers, is(expected));
    }

}