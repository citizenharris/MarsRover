package com.codurance.marsrover;

import java.util.List;
import java.util.Map;

class CombustionEngine implements PropulsionEngine {
    private final int maximumGridSize;
    private final List<GridPoint> obstacles;

    private final Map<Compass, VectorFunction> possibleMoves;

    public CombustionEngine(int gridSize, List<GridPoint> obstacles) {
        this.maximumGridSize = gridSize;
        this.obstacles = obstacles;
        possibleMoves = Map.of(
                Compass.EAST, this::moveAlongX,
                Compass.WEST, this::moveAlongX,
                Compass.NORTH, this::moveAlongY,
                Compass.SOUTH, this::moveAlongY
        );
    }

    public GridPoint engage(GridPoint currentPosition, Compass heading) {
        var updatePosition = getPossibleMoveFor(heading);
        return updatePosition.engage(currentPosition, heading);
    }

    private VectorFunction getPossibleMoveFor(Compass heading) {
        return possibleMoves.get(heading);
    }

    private GridPoint moveAlongY(GridPoint currentPosition, Compass heading) {
        return heading == Compass.NORTH
                ? hasObstacle(currentPosition, new GridPoint(currentPosition.x, getPositiveMovementFor(currentPosition.y)))
                : hasObstacle(currentPosition, new GridPoint(currentPosition.x, getNegativeMovementFor(currentPosition.y)));
    }

    private GridPoint moveAlongX(GridPoint currentPosition, Compass heading) {
        return heading == Compass.EAST
                ? hasObstacle(currentPosition, new GridPoint(getPositiveMovementFor(currentPosition.x), currentPosition.y))
                : hasObstacle(currentPosition, new GridPoint(getNegativeMovementFor(currentPosition.x), currentPosition.y));
    }

    private GridPoint hasObstacle(GridPoint currentPosition, GridPoint intendedPosition) {
        return obstacles.contains(intendedPosition)
                ? currentPosition // obstacled grid point here
                : intendedPosition;
    }

    private int getNegativeMovementFor(int axisValue) {
        return axisValue > 0 ? axisValue - 1 : maximumGridSize - 1;
    }

    private int getPositiveMovementFor(int axisValue) {
        return (axisValue + 1) % maximumGridSize;
    }

    @FunctionalInterface
    interface VectorFunction {
        GridPoint engage(GridPoint currentPosition, Compass heading);
    }
}
