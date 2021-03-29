package com.codurance.marsrover;

class Obstacle extends GridPoint{
    Obstacle(GridPoint gridPoint) {
        super(gridPoint.x, gridPoint.y);
    }

    @Override
    public String toString() {
        return "O:" + super.toString();
    }
}
