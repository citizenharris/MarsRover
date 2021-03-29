package com.codurance.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionFinderShould {
    private DirectionFinder directionFinder;

    @BeforeEach
    void setUp() {
        directionFinder = new DirectionFinder();
    }

    @Test
    void find_west_left_of_north() {
        assertEquals(Compass.WEST, directionFinder.getLeft(Compass.NORTH));
    }

    @Test
    void find_south_left_of_west() {
        assertEquals(Compass.SOUTH, directionFinder.getLeft(Compass.WEST));
    }

    @Test
    void find_east_left_of_south() {
        assertEquals(Compass.EAST, directionFinder.getLeft(Compass.SOUTH));
    }

    @Test
    void find_north_left_of_east() {
        assertEquals(Compass.NORTH, directionFinder.getLeft(Compass.EAST));
    }

    @Test
    void find_east_right_of_north() {
        assertEquals(Compass.EAST, directionFinder.getRight(Compass.NORTH) );
    }

    @Test
    void find_south_right_of_east() {
        assertEquals(Compass.SOUTH, directionFinder.getRight(Compass.EAST) );
    }

    @Test
    void find_west_right_of_south() {
        assertEquals(Compass.WEST, directionFinder.getRight(Compass.SOUTH) );
    }

    @Test
    void find_north_right_of_west() {
        assertEquals(Compass.NORTH, directionFinder.getRight(Compass.WEST) );
    }
}