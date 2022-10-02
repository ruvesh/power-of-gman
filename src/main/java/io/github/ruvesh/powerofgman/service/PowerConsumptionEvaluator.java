package io.github.ruvesh.powerofgman.service;

import io.github.ruvesh.powerofgman.common.constant.Directions;
import io.github.ruvesh.powerofgman.common.constant.StringConstants;
import io.github.ruvesh.powerofgman.service.model.ConsumptionCostModel;
import io.github.ruvesh.powerofgman.service.model.Coordinate;

/**
 * Implementation for Evaluation of GMan's power consumption
 * @author ruvesh
 * @since 1.0
 */
public class PowerConsumptionEvaluator implements ConsumptionEvaluator{

    private int distanceTravelledX;
    private int distanceTravelledY;

    /**
     * Evaluates the power consumption made by GMan's moves
     * @param sourceCoordinate initial position of GMan
     * @param destinationCoordinate final position of GMan
     * @param directionFacing initial direction in which GMan is facing
     * @param consumptionCostModel consumption cost parameters for GMan's moves
     * @return the total power consumed by GMan
     */
    @Override
    public int evaluateConsumption(Coordinate sourceCoordinate, Coordinate destinationCoordinate, String directionFacing, ConsumptionCostModel consumptionCostModel) {
        int totalTravelCost = calculateTotalTravelCost(sourceCoordinate, destinationCoordinate, consumptionCostModel.getTravellingCost());
        int totalTurningCost = consumptionCostModel.getTurningCost() * calculateNoOfTurns(sourceCoordinate, destinationCoordinate, directionFacing);
        return (totalTravelCost + totalTurningCost);
    }

    /**
     * Evaluates the total cost of travelling from source to destination
     * @param sourceCoordinate initial position of GMan
     * @param destinationCoordinate final position of GMan
     * @param travellingCost cost for making one move towards an adjacent coordinate
     * @return total cost of travelling from source to destination
     */
    private int calculateTotalTravelCost(Coordinate sourceCoordinate, Coordinate destinationCoordinate, int travellingCost){
        calculateDistanceTravelled(sourceCoordinate, destinationCoordinate);
        return (distanceTravelledX + distanceTravelledY) * travellingCost;
    }

    /**
     * Evaluates the total distance travelled by GMan from source to destination
     * @param sourceCoordinate initial position of GMan
     * @param destinationCoordinate final position of GMan
     */
    private void calculateDistanceTravelled(Coordinate sourceCoordinate, Coordinate destinationCoordinate){
        distanceTravelledX = Math.abs(sourceCoordinate.getX() - destinationCoordinate.getX());
        distanceTravelledY = Math.abs(sourceCoordinate.getY() - destinationCoordinate.getY());
    }

    /**
     * Evaluates the number of turns taken by GMan to reach the destination
     * @param sourceCoordinate initial position of GMan
     * @param destinationCoordinate final position of GMan
     * @param directionFacing initial direction in which GMan is facing
     * @return number of turns made by GMan
     */
    private int calculateNoOfTurns(Coordinate sourceCoordinate, Coordinate destinationCoordinate, String directionFacing){
        int turns = 0;
        int sourceX = sourceCoordinate.getX();
        int sourceY = sourceCoordinate.getY();
        int destinationX = destinationCoordinate.getX();
        int destinationY = destinationCoordinate.getY();
        String skipTurnDirection;
        if(sourceX == destinationX) {
            turns += calculate180DegreeTurn(sourceY, destinationY, directionFacing, StringConstants.Y_AXIS);
        }
        else {
            skipTurnDirection = sourceX > destinationX ? Directions.WEST.getLabel() : Directions.EAST.getLabel();
            if(!directionFacing.equalsIgnoreCase(skipTurnDirection))
                turns++;
        }
        if(sourceY == destinationY) {
            turns += calculate180DegreeTurn(sourceX, destinationX, directionFacing, StringConstants.X_AXIS);
        }
        else {
            skipTurnDirection = sourceY > destinationY ? Directions.SOUTH.getLabel() : Directions.NORTH.getLabel();
            if(!directionFacing.equalsIgnoreCase(skipTurnDirection))
                turns++;
        }
        return turns;
    }

    /**
     * Finds whether a double turn was made
     * @param sourceCoordinate initial x or y coordinate of GMan
     * @param destinationCoordinate final x or y coordinate of GMan
     * @param directionFacing initial direction in which GMan is facing
     * @return 0 if 180 turn is not required <br/> 1 if 180 turn is required
     */
    private int calculate180DegreeTurn(int sourceCoordinate, int destinationCoordinate, String directionFacing, String axis) {
        switch (axis){
            case StringConstants.X_AXIS:
                if ((destinationCoordinate > sourceCoordinate) && directionFacing.equalsIgnoreCase(Directions.WEST.getLabel())
                        || (destinationCoordinate < sourceCoordinate) && directionFacing.equalsIgnoreCase(Directions.EAST.getLabel()))
                    return 1;
                return 0;
            case StringConstants.Y_AXIS:
                if ((destinationCoordinate > sourceCoordinate) && directionFacing.equalsIgnoreCase(Directions.SOUTH.getLabel())
                                || (destinationCoordinate < sourceCoordinate) && directionFacing.equalsIgnoreCase(Directions.NORTH.getLabel()))
                    return 1;
                return 0;
            default: return 0;
        }
    }
}
