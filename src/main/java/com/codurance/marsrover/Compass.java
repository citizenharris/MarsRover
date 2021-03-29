package com.codurance.marsrover;

public enum Compass {
    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");

    private final String direction;

    Compass(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return direction;
    }
}
