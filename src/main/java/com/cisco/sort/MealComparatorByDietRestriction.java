package com.cisco.sort;

import com.cisco.Meal;

import java.util.Comparator;

/**
 * Sorts meals by their dietary restrictions descending where empty space is last i.e. no diet restriction
 */
public class MealComparatorByDietRestriction implements Comparator<Meal> {

    public int compare(Meal meal1, Meal meal2) {
        return meal2.getDietRestriction().compareTo(meal1.getDietRestriction());
    }
}