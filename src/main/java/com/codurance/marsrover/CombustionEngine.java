package com.codurance.marsrover;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

class CombustionEngine implements PropulsionEngine {
    private final int maximumGridSize;
    private final List<GridPoint> obstacles;

    private final Map<Direction, BiFunction<GridPoint, Direction, GridPoint>> possibleMoves;

    public CombustionEngine(int gridSize, List<GridPoint> obstacles) {
        this.maximumGridSize = gridSize;
        this.obstacles = obstacles;
        possibleMoves = Map.of(
                Direction.EAST, this::moveAlongX,
                Direction.WEST, this::moveAlongX,
                Direction.NORTH, this::moveAlongY,
                Direction.SOUTH, this::moveAlongY
        );
    }

    public GridPoint engage(GridPoint currentPosition, Direction heading) {
        var updatePosition = getPossibleMoveFor(heading);
        return updatePosition.apply(currentPosition, heading);
    }

    private BiFunction<GridPoint, Direction, GridPoint> getPossibleMoveFor(Direction heading) {
        return possibleMoves.get(heading);
    }

    private GridPoint moveAlongY(GridPoint currentPosition, Direction heading) {
        return heading == Direction.NORTH
                ? hasObstacle(currentPosition, new GridPoint(currentPosition.x, getPositiveMovementFor(currentPosition.y)))
                : hasObstacle(currentPosition, new GridPoint(currentPosition.x, getNegativeMovementFor(currentPosition.y)));
    }

    private GridPoint moveAlongX(GridPoint currentPosition, Direction heading) {
        return heading == Direction.EAST
                ? hasObstacle(currentPosition, new GridPoint(getPositiveMovementFor(currentPosition.x), currentPosition.y))
                : hasObstacle(currentPosition, new GridPoint(getNegativeMovementFor(currentPosition.x), currentPosition.y));
    }

    private GridPoint hasObstacle(GridPoint currentPosition, GridPoint intendedPosition) {
        return obstacles.contains(intendedPosition)
                ? currentPosition
                : intendedPosition;
    }

    private int getNegativeMovementFor(int axisValue) {
        return axisValue > 0 ? axisValue - 1 : maximumGridSize - 1;
    }

    private int getPositiveMovementFor(int axisValue) {
        return (axisValue + 1) % maximumGridSize;
    }
}
