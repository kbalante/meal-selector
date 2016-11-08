package com.cisco;

/**
 * Rating of restaurants
 */
public class Rating {
    private int value;
    private final static int MIN_RATING = 0;
    private final static int MAX_RATING = 5;

    public Rating(int rating) {
        // check that the rating is between the acceptable range
        if ((rating < MIN_RATING) && (rating > MAX_RATING)) {
            throw new IllegalArgumentException("rating out of range");
        } else {
            this.value = rating;
        }
    }

    public int getValue() {
        return value;
    }
}
