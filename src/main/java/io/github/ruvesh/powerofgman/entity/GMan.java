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


    public Coordinate getSourceCoordinate() {
        return this.sourceCoordinate;
    }

    public void setSourceCoordinate(Coordinate sourceCoordinate) {
        this.sourceCoordinate = sourceCoordinate;
    }

    public Coordinate getDestinationCoordinate() {
        return this.destinationCoordinate;
    }

    public void setDestinationCoordinate(Coordinate destinationCoordinate) {
        this.destinationCoordinate = destinationCoordinate;
    }

    public String getDirectionFacing() {
        return directionFacing;
    }

    public void setDirectionFacing(String directionFacing) {
        this.directionFacing = directionFacing;
    }
}
