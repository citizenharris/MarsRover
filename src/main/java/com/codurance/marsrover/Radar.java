package com.codurance.marsrover;

public class Radar implements NavigationSystem {
    private static final char LEFT = 'L';
    public static final char RIGHT = 'R';
    private final DirectionFinder directionFinder;
    private Direction heading;

    public Radar(Direction heading) {
        this.heading = heading;
        directionFinder = new DirectionFinder();
    }

    public void turn(char direction) {
        if (direction == LEFT)
            turnLeft();

        if (direction == RIGHT)
            turnRight();
    }

    private void turnRight() {
        heading = directionFinder.getRight(heading);
    }

    private void turnLeft() {
        heading = directionFinder.getLeft(heading);
    }

    public Direction getHeading() {
        return heading;
    }
}
