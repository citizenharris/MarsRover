package com.codurance.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;


class RoverShould {

    private MarsRover rover;

    @BeforeEach
    void setUp() {
        var initialPosition = new GridPoint(0, 0);
        var obstacles = new ArrayList<GridPoint>();
        var mapSetup = new MapSetup(Compass.NORTH, 10, initialPosition, obstacles);
        rover = new MarsRover(mapSetup);
    }

    @Test
    void start_at_0_0_N() {
        assertEquals("0:0:N", rover.execute(""));
    }

    @ParameterizedTest
    @CsvSource({
            "0:0:W, L",
            "0:0:S, LL",
            "0:0:E, LLL",
            "0:0:N, LLLL"
    })
    void turn_left(String expectedPosition, String commands) {
        assertEquals(expectedPosition, rover.execute(commands));
    }

    @ParameterizedTest
    @CsvSource({
            "0:0:E, R",
            "0:0:S, RR",
            "0:0:W, RRR",
            "0:0:N, RRRR"
    })
    void turn_right(String expectedPosition, String commands) {
        assertEquals(expectedPosition, rover.execute(commands));
    }

    @ParameterizedTest
    @CsvSource({
            "0:1:N, M",
            "0:2:N, MM",
            "0:4:N, MMMM",
            "0:9:N, MMMMMMMMM",
            "0:0:N, MMMMMMMMMM"
    })
    void move_north(String expectedPosition, String commands) {
        assertEquals(expectedPosition, rover.execute(commands));
    }

    @ParameterizedTest
    @CsvSource({
            "1:0:E, RM",
            "2:0:E, RMM",
            "4:0:E, RMMMM",
            "9:0:E, RMMMMMMMMM",
            "0:0:E, RMMMMMMMMMM",
    })
    void move_east(String expectedPosition, String commands) {
        assertEquals(expectedPosition, rover.execute(commands));
    }

    @ParameterizedTest
    @CsvSource({
            "0:9:S, RRM",
            "0:8:S, RRMM",
            "0:6:S, RRMMMM",
            "0:1:S, RRMMMMMMMMM",
            "0:0:S, RRMMMMMMMMMM"
    })
    void move_south(String expectedPosition, String commands) {
        assertEquals(expectedPosition, rover.execute(commands));
    }

    @ParameterizedTest
    @CsvSource({
            "9:0:W, LM",
            "8:0:W, LMM",
            "6:0:W, LMMMM",
            "1:0:W, LMMMMMMMMM",
            "0:0:W, LMMMMMMMMMM"
    })
    void move_west(String expectedPosition, String commands) {
        assertEquals(expectedPosition, rover.execute(commands));
    }

    @ParameterizedTest
    @CsvSource({
            "O:0:3:N, MMMM",
            "O:2:0:E, RMMM"
    })
    void stop_at_an_obstacle(String expectedPosition, String commands) {
        var obstacles = asList(
                new GridPoint(0, 4),
                new GridPoint(3, 0)
        );
        var initialPosition = new GridPoint(0, 0);
        var mapSetup = new MapSetup(Compass.NORTH, 10, initialPosition, obstacles);
        var obstructedRover = new MarsRover(mapSetup);

        assertEquals(expectedPosition, obstructedRover.execute(commands));
    }
}
