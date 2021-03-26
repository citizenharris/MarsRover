package com.codurance.marsrover;

import java.util.Map;

public class DirectionFinder {
    private final Map<Direction, Direction> leftMap;
    private final Map<Direction, Direction> rightMap;

    DirectionFinder() {
        this.leftMap = Map.of(
                Direction.NORTH, Direction.WEST,
                Direction.WEST, Direction.SOUTH,
                Direction.SOUTH, Direction.EAST,
                Direction.EAST, Direction.NORTH
        );

        this.rightMap = Map.of(
                Direction.NORTH, Direction.EAST,
                Direction.EAST, Direction.SOUTH,
                Direction.SOUTH, Direction.WEST,
                Direction.WEST, Direction.NORTH
        );
    }

    public Direction getLeft(Direction direction) { return leftMap.get(direction); }

    public Direction getRight(Direction direction) { return rightMap.get(direction); }
}
