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
        assertEquals(Direction.WEST, directionFinder.getLeft(Direction.NORTH));
    }

    @Test
    void find_south_left_of_west() {
        assertEquals(Direction.SOUTH, directionFinder.getLeft(Direction.WEST));
    }

    @Test
    void find_east_left_of_south() {
        assertEquals(Direction.EAST, directionFinder.getLeft(Direction.SOUTH));
    }

    @Test
    void find_north_left_of_east() {
        assertEquals(Direction.NORTH, directionFinder.getLeft(Direction.EAST));
    }

    @Test
    void find_east_right_of_north() {
        assertEquals(Direction.EAST, directionFinder.getRight(Direction.NORTH) );
    }

    @Test
    void find_south_right_of_east() {
        assertEquals(Direction.SOUTH, directionFinder.getRight(Direction.EAST) );
    }

    @Test
    void find_west_right_of_south() {
        assertEquals(Direction.WEST, directionFinder.getRight(Direction.SOUTH) );
    }

    @Test
    void find_north_right_of_west() {
        assertEquals(Direction.NORTH, directionFinder.getRight(Direction.WEST) );
    }
}