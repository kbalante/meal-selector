package com.cisco;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests the team members
 */
public class TeamMemberTest {

    /**
     * Test that the hasMeal function works properly
     * @throws Exception if there is an error
     */
    @Test
    public void hasMeal() throws Exception {

        TeamMember teamMember = new TeamMember("Keith Balante", DietRestriction.NONE);
        teamMember.setMeal(new Meal("Pancakes", DietRestriction.NONE));
        assertTrue(teamMember.hasMeal());

        // steal the meal away from him and see if he still thinks he has it
        teamMember.setMeal(null);
        assertFalse(teamMember.hasMeal());
    }
}