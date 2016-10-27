package com.cisco.sort;

import com.cisco.TeamMember;

import java.util.Comparator;

/**
 * Sorts team members by their diet restrictions descending where empty space is last i.e. no diet restriction
 */
public class TeamMemberComparatorByDietRestriction implements Comparator<TeamMember> {

    public int compare(TeamMember teamMember1, TeamMember teamMember2) {
        return teamMember2.getDietRestriction().compareTo(teamMember1.getDietRestriction());
    }
}