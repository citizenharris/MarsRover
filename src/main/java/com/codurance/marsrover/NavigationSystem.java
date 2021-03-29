package com.codurance.marsrover;

public interface NavigationSystem {
    void turn(char direction);
    Compass getHeading();
}
