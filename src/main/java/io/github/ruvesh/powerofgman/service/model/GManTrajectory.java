package io.github.ruvesh.powerofgman.service.model;

public class GManTrajectory {
    Coordinate source;
    Coordinate destination;
    String currentDirection;
    ConsumptionCostModel consumptionCostModel;

    public GManTrajectory(Coordinate source, Coordinate destination, String currentDirection, ConsumptionCostModel consumptionCostModel) {
        this.source = source;
        this.destination = destination;
        this.currentDirection = currentDirection;
        this.consumptionCostModel = consumptionCostModel;
    }

    public Coordinate getSource() {
        return source;
    }

    public Coordinate getDestination() {
        return destination;
    }

    public String getCurrentDirection() {
        return currentDirection;
    }

    public ConsumptionCostModel getConsumptionCostModel() {
        return consumptionCostModel;
    }
}
