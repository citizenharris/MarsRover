package com.codurance.marsrover;

public enum Direction {
    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");

    private final String heading;

    Direction(String heading) {
        this.heading = heading;
    }

    @Override
    public String toString() {
        return heading;
    }
}
