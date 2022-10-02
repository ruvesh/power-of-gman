package io.github.ruvesh.powerofgman.entity;

import io.github.ruvesh.powerofgman.service.model.Coordinate;

/**
 * Represents the details of the character's current position, direction and destination position
 * @author ruvesh
 * @since 1.0
 */
public class GMan {
    private Coordinate sourceCoordinate;
    private Coordinate destinationCoordinate;
    private String directionFacing;

    /**
     * Getter for {@link #sourceCoordinate}
     * @return {@link Coordinate}
     */
    public Coordinate getSourceCoordinate() {
        return this.sourceCoordinate;
    }

    /**
     * Setter for {@link #sourceCoordinate}
     */
    public void setSourceCoordinate(Coordinate sourceCoordinate) {
        this.sourceCoordinate = sourceCoordinate;
    }

    /**
     * Getter for {@link #destinationCoordinate}
     * @return {@link Coordinate}
     */
    public Coordinate getDestinationCoordinate() {
        return this.destinationCoordinate;
    }

    /**
     * Setter for {@link #destinationCoordinate}
     */
    public void setDestinationCoordinate(Coordinate destinationCoordinate) {
        this.destinationCoordinate = destinationCoordinate;
    }

    /**
     * Getter for {@link #directionFacing}
     * @return {@link String}
     */
    public String getDirectionFacing() {
        return directionFacing;
    }

    /**
     * Setter for {@link #directionFacing}
     */
    public void setDirectionFacing(String directionFacing) {
        this.directionFacing = directionFacing;
    }
}
