package com.codurance.marsrover;

public interface PropulsionEngine {
    GridPoint engage(GridPoint currentPosition, Direction heading);
}
