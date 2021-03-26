package com.codurance.marsrover;

import java.util.List;

public class MapSetup {
    private final Direction initialHeading;
    private final int gridSize;
    private final GridPoint initialPosition;
    private final List<GridPoint> obstacles;

    public MapSetup(Direction initialHeading, int gridSize, GridPoint initialPosition, List<GridPoint> obstacles) {
        this.initialHeading = initialHeading;
        this.gridSize = gridSize;
        this.initialPosition = initialPosition;
        this.obstacles = obstacles;
    }

    public Direction getInitialHeading() {
        return initialHeading;
    }

    public int getGridSize() {
        return gridSize;
    }

    public GridPoint getInitialPosition() {
        return initialPosition;
    }

    public List<GridPoint> getObstacles() {
        return obstacles;
    }
}
