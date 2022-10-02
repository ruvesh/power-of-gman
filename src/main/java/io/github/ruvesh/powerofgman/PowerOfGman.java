package io.github.ruvesh.powerofgman;

import io.github.ruvesh.powerofgman.common.util.DriverCodeUtil;
import io.github.ruvesh.powerofgman.service.model.ConsumptionCostModel;

import java.io.IOException;

/**
 * Entrypoint
 * @author ruvesh
 * @since 1.0
 */
public class PowerOfGman {

    /**
     * Main Class
     * @param args will contain the command line arguments having the input file path
     */
    public static void main(String[] args) {
        try {
            ConsumptionCostModel consumptionCostModel = new ConsumptionCostModel(200, 10, 5);
            DriverCodeUtil.readInputsAndProcessResults(args[0], consumptionCostModel);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
