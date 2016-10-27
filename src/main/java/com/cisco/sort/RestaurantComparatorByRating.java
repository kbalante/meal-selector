package com.cisco.sort;

import com.cisco.Restaurant;

import java.util.Comparator;

/**
 * Sorts restaurants by their ratings in descending order
 */
public class RestaurantComparatorByRating implements Comparator<Restaurant> {

    public int compare(Restaurant restaurant1, Restaurant restaurant2) {
        return restaurant2.getRating() - restaurant1.getRating();
    }
}