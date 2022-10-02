package io.github.ruvesh.powerofgman.service.model;

/**
 * Represents the consumption cost parameters for the character's moves
 * @author ruvesh
 * @since 1.0
 */
public class ConsumptionCostModel {
    private final int totalPower;
    private final int travellingCost;
    private final int turningCost;

    /**
     * Overloaded Constructor
     * @param totalPower total power of the character
     * @param travellingCost cost for making a move to adjacent coordinate
     * @param turningCost cost for making one left or right turn
     */
    public ConsumptionCostModel(int totalPower, int travellingCost, int turningCost) {
        this.totalPower = totalPower;
        this.travellingCost = travellingCost;
        this.turningCost = turningCost;
    }

    /**
     * Getter for {@link #totalPower}
     * @return {@link #totalPower}
     */
    public int getTotalPower() {
        return totalPower;
    }

    /**
     * Getter for {@link #travellingCost}
     * @return {@link #travellingCost}
     */
    public int getTravellingCost() {
        return travellingCost;
    }

    /**
     * Getter for {@link #turningCost}
     * @return {@link #turningCost}
     */
    public int getTurningCost() {
        return turningCost;
    }
}
