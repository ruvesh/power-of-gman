package io.github.ruvesh.powerofgman.service;

import io.github.ruvesh.powerofgman.service.model.ConsumptionCostModel;
import io.github.ruvesh.powerofgman.service.model.Coordinate;

/**
 * Represents the contract for evaluating the consumption for character's moves
 * @author ruvesh
 * @since 1.0
 */
public interface ConsumptionEvaluator {

    /**
     * Contract for evaluating the consumption for the character's moves
     * @param sourceCoordinate initial position of the character
     * @param destinationCoordinate final position of the character
     * @param directionFacing initial direction in which the character is facing
     * @param consumptionCostModel consumption cost parameters for the character's moves
     * @return consumption of power or energy for making the moves
     */
    int evaluateConsumption(Coordinate sourceCoordinate, Coordinate destinationCoordinate, String directionFacing, ConsumptionCostModel consumptionCostModel);
}
