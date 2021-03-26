package com.codurance.marsrover;

import java.util.Objects;

public class GridPoint {
    public final int x;
    public final int y;

    GridPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + ":" + y;
    }
    
    @Override
    public boolean equals(Object obj) {
    
        if (obj == this) return true;
        if (!(obj instanceof GridPoint)) return false;
        
        GridPoint gridPoint = (GridPoint) obj;
        return Objects.equals(x, gridPoint.x) &&
                Objects.equals(y, gridPoint.y);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
