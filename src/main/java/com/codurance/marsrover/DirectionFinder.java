package com.codurance.marsrover;

import java.util.Map;

public class DirectionFinder {
    private final Map<Compass, Compass> leftMap;
    private final Map<Compass, Compass> rightMap;

    DirectionFinder() {
        this.leftMap = Map.of(
                Compass.NORTH, Compass.WEST,
                Compass.WEST, Compass.SOUTH,
                Compass.SOUTH, Compass.EAST,
                Compass.EAST, Compass.NORTH
        );

        this.rightMap = Map.of(
                Compass.NORTH, Compass.EAST,
                Compass.EAST, Compass.SOUTH,
                Compass.SOUTH, Compass.WEST,
                Compass.WEST, Compass.NORTH
        );
    }

    public Compass getLeft(Compass direction) { return leftMap.get(direction); }

    public Compass getRight(Compass direction) { return rightMap.get(direction); }
}
