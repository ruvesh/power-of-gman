package io.github.ruvesh.powerofgman.service.model;

/**
 * Represents the coordinates for the character's position on the grid
 * @author ruvesh
 * @since 1.0
 */
public class Coordinate {
    private final int x;
    private final int y;

    /**
     * Overloaded Constructor
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for x-coordinate
     * @return {@link #x}
     */
    public int getX() {
        return x;
    }


    /**
     * Getter for y-coordinate
     * @return {@link #y}
     */
    public int getY() {
        return y;
    }
}
