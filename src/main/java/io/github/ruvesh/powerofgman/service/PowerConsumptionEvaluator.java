package io.github.ruvesh.powerofgman.service;

import io.github.ruvesh.powerofgman.common.constant.Directions;
import io.github.ruvesh.powerofgman.common.constant.StringConstants;
import io.github.ruvesh.powerofgman.service.model.Coordinate;
import io.github.ruvesh.powerofgman.service.model.GManTrajectory;

/**
 * Implementation for Evaluation of GMan's power consumption
 * @author ruvesh
 * @since 1.0
 */
public class PowerConsumptionEvaluator implements ConsumptionEvaluator{

    private int distanceTravelledX;
    private int distanceTravelledY;

    @Override
    public int evaluateConsumption(GManTrajectory gManTrajectory) {
        int totalTravelCost = calculateTotalTravelCost(gManTrajectory);
        int totalTurningCost = gManTrajectory.getConsumptionCostModel().getTurningCost() * calculateNoOfTurns(gManTrajectory);
        return (totalTravelCost + totalTurningCost);
    }

    private int calculateTotalTravelCost(GManTrajectory gManTrajectory){
        calculateDistanceTravelled(gManTrajectory.getSource(), gManTrajectory.getDestination());
        return (distanceTravelledX + distanceTravelledY) * gManTrajectory.getConsumptionCostModel().getTravellingCost();
    }


    private void calculateDistanceTravelled(Coordinate sourceCoordinate, Coordinate destinationCoordinate){
        distanceTravelledX = Math.abs(sourceCoordinate.getX() - destinationCoordinate.getX());
        distanceTravelledY = Math.abs(sourceCoordinate.getY() - destinationCoordinate.getY());
    }

    private int calculateNoOfTurns(GManTrajectory gManTrajectory){
        int turns = 0;
        int sourceX = gManTrajectory.getSource().getX();
        int sourceY = gManTrajectory.getSource().getY();
        int destinationX = gManTrajectory.getDestination().getX();
        int destinationY = gManTrajectory.getDestination().getY();
        String skipTurnDirection;
        String directionFacing = gManTrajectory.getCurrentDirection();
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
