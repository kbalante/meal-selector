package com.cisco.sort;

import com.cisco.DietRestriction;
import com.cisco.TeamMember;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests the sorting of the team members
 */
public class TeamMemberComparatorByDietRestrictionTest {
    @Test
    public void compare() throws Exception {
        TeamMember teamMember1 = new TeamMember("Keith Balante", DietRestriction.PEANUT_FREE);
        TeamMember teamMember2 = new TeamMember("John Esquires", DietRestriction.ABC);
        TeamMember teamMember3 = new TeamMember("Kevin Quan", DietRestriction.NONE);
        TeamMember teamMember4 = new TeamMember("Elaine Balante", DietRestriction.VEGAN);

        ArrayList<TeamMember> actual = new ArrayList<TeamMember>();
        actual.add(teamMember1);
        actual.add(teamMember2);
        actual.add(teamMember3);
        actual.add(teamMember4);
        Collections.sort(actual, new TeamMemberComparatorByDietRestriction());

        // expected list ordering
        ArrayList<TeamMember> expected = new ArrayList<TeamMember>();
        expected.add(teamMember4);
        expected.add(teamMember1);
        expected.add(teamMember2);
        expected.add(teamMember3);

        // check that the ordering is correct
        assertThat(actual, is(expected));
    }

}