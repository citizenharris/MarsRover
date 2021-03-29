package com.codurance.marsrover;

public interface PropulsionEngine {
    GridPoint engage(GridPoint currentPosition, Compass heading);
}
