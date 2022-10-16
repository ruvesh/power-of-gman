package io.github.ruvesh.powerofgman.service;

import io.github.ruvesh.powerofgman.service.model.GManTrajectory;

/**
 * Represents the contract for evaluating the consumption for character's moves
 * @author ruvesh
 * @since 1.0
 */
public interface ConsumptionEvaluator {

    int evaluateConsumption(GManTrajectory gManTrajectory);
}
