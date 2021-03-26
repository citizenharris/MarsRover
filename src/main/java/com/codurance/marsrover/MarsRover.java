package com.codurance.marsrover;

public class MarsRover {

    private final NavigationSystem navigator;
    private final PropulsionEngine thrusters;
    private GridPoint currentPosition;
    private boolean isObstructed;

    public MarsRover(MapSetup mapSetup) {
        this.navigator = new Radar(mapSetup.getInitialHeading());
        this.thrusters = new CombustionEngine(mapSetup.getGridSize(), mapSetup.getObstacles());
        this.currentPosition = mapSetup.getInitialPosition();
    }

    public String execute(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == 'M') {
                move(navigator.getHeading());
                continue;
            }

            turnTo(command);
        }
        return positionToString();
    }

    private void move(Direction heading) {
        var newPosition = thrusters.engage(currentPosition, heading);
        isObstructed = newPosition.equals(currentPosition);
        currentPosition = newPosition;
    }

    private void turnTo(char direction) {
        navigator.turn(direction);
    }

    private String positionToString() {
        return isObstructed
            ? "O:" + calculatePosition()
            : calculatePosition();
    }

    private String calculatePosition() {
        return currentPosition.toString() + ":" + navigator.getHeading();
    }
}
