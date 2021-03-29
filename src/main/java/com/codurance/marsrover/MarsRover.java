package com.codurance.marsrover;

public class MarsRover {

    private final NavigationSystem navigator;
    private final PropulsionEngine thrusters;
    private GridPoint currentPosition;

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
        return calculatePosition();
    }

    private void move(Compass heading) {
        currentPosition = thrusters.engage(currentPosition, heading);
    }

    private void turnTo(char direction) {
        navigator.turn(direction);
    }

    private String calculatePosition() {
        return currentPosition.toString() + ":" + navigator.getHeading();
    }
}
