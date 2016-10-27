package com.cisco.sort;

import com.cisco.Restaurant;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test the sorting of the restaurants
 */
public class RestaurantComparatorByRatingTest {
    @Test
    public void compare() throws Exception {
        Restaurant restaurant1 = new Restaurant("Deluxe Diner", 1);
        Restaurant restaurant2 = new Restaurant("Crab Shack", 2);
        Restaurant restaurant3 = new Restaurant("Budha's Delight", 5);
        Restaurant restaurant4 = new Restaurant("Tex Mex Hut", 3);

        ArrayList<Restaurant> actual = new ArrayList<Restaurant>();
        actual.add(restaurant1);
        actual.add(restaurant2);
        actual.add(restaurant3);
        actual.add(restaurant4);

        // sort by rating descending
        Collections.sort(actual, new RestaurantComparatorByRating());

        // expected list ordering
        ArrayList<Restaurant> expected = new ArrayList<Restaurant>();
        expected.add(restaurant3);
        expected.add(restaurant4);
        expected.add(restaurant2);
        expected.add(restaurant1);

        // check that the ordering is correct
        assertThat(actual, is(expected));
    }

}