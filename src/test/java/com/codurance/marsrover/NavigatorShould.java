package com.codurance.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NavigatorShould {

    public static final char LEFT = 'L';
    public static final char RIGHT = 'R';
    private NavigationSystem northFacingRadar;

    @BeforeEach
    void setUp() {
        northFacingRadar = new Radar(Direction.NORTH);
    }

    @ParameterizedTest
    @CsvSource({
            "WEST, 1",
            "SOUTH, 2",
            "EAST, 3",
            "NORTH, 4"
    })
    void turn_left_from_north(Direction expectedDirection, int turns) {
        turn(LEFT, turns, northFacingRadar);
        assertEquals(expectedDirection, northFacingRadar.getHeading());
    }

    @ParameterizedTest
    @CsvSource({
            "EAST, 1",
            "NORTH, 2",
            "WEST, 3",
            "SOUTH, 4"
    })
    void turn_left_from_south(Direction expectedDirection, int turns) {
        var southFacingNavigator = new Radar(Direction.SOUTH);
        turn(LEFT, turns, southFacingNavigator);
        assertEquals(expectedDirection, southFacingNavigator.getHeading());
    }

    @ParameterizedTest
    @CsvSource({
            "EAST, 1",
            "SOUTH, 2",
            "WEST, 3",
            "NORTH, 4"
    })
    void turn_right_from_north(Direction expectedDirection, int turns) {
        turn(RIGHT, turns, northFacingRadar);
        assertEquals(expectedDirection, northFacingRadar.getHeading());
    }

    @ParameterizedTest
    @CsvSource({
            "WEST, 1",
            "NORTH, 2",
            "EAST, 3",
            "SOUTH, 4"
    })
    void turn_right_from_south(Direction expectedDirection, int turns) {
        var southFacingNavigator = new Radar(Direction.SOUTH);
        turn(RIGHT, turns, southFacingNavigator);
        assertEquals(expectedDirection, southFacingNavigator.getHeading());
    }

    private void turn(char direction, int turns, NavigationSystem navigator) {
        for (int i = 0; i < turns; i++) {
            navigator.turn(direction);
        }
    }
}
