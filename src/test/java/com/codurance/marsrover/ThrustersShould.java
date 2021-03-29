package com.codurance.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThrustersShould {

    public static final int GRID_SIZE = 10;
    private PropulsionEngine thrusters;
    private GridPoint currentPosition;

    @BeforeEach
    void setUp() {
        thrusters = new CombustionEngine(GRID_SIZE, new ArrayList<>());
        currentPosition = new GridPoint(0, 0);
    }

    @Test
    void move_north() {
        var expectedPosition = new GridPoint(0, 1);
        assertEquals(expectedPosition, thrusters.engage(currentPosition, Compass.NORTH));
    }

    @Test
    void move_east() {
        var expectedPosition = new GridPoint(1, 0);
        assertEquals(expectedPosition, thrusters.engage(currentPosition, Compass.EAST));
    }

    @Test
    void move_south() {
        var expectedPosition = new GridPoint(0, 9);
        assertEquals(expectedPosition, thrusters.engage(currentPosition, Compass.SOUTH));
    }

    @Test
    void move_west() {
        var expectedPosition = new GridPoint(9, 0);
        assertEquals(expectedPosition, thrusters.engage(currentPosition, Compass.WEST));
    }
}
