package com.cisco.sort;

import com.cisco.DietRestriction;
import com.cisco.Meal;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Test the sorting of the meals
 */
public class MealComparatorByDietRestrictionTest {

    @Test
    public void compare() throws Exception {
        Meal meal1 = new Meal("Brocoli with ketchup", DietRestriction.VEGAN);
        Meal meal2 = new Meal("Shephard's Pie", DietRestriction.NONE);
        Meal meal3 = new Meal("Cricket stew", DietRestriction.ABC);
        Meal meal4 = new Meal("farm fresh eggs & ham", DietRestriction.PEANUT_FREE);

        ArrayList<Meal> actual = new ArrayList<Meal>();
        actual.add(meal1);
        actual.add(meal2);
        actual.add(meal3);
        actual.add(meal4);
        Collections.sort(actual, new MealComparatorByDietRestriction());

        // expected list ordering
        ArrayList<Meal> expected = new ArrayList<Meal>();
        expected.add(meal1);
        expected.add(meal4);
        expected.add(meal3);
        expected.add(meal2);

        // check that the ordering is correct
        assertThat(actual, is(expected));
    }
}