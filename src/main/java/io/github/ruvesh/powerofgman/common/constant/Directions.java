package io.github.ruvesh.powerofgman.common.constant;

/**
 * Represents the Enum Constant for the Four Directions
 * @author ruvesh
 * @since 1.0
 */
public enum Directions {
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    private final String label;

    private Directions(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
