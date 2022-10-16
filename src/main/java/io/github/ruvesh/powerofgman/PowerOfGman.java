package io.github.ruvesh.powerofgman;

import io.github.ruvesh.powerofgman.common.util.DriverCodeUtil;
import io.github.ruvesh.powerofgman.service.model.ConsumptionCostModel;

import java.io.IOException;
import java.util.List;

/**
 * Entrypoint
 * @author ruvesh
 * @since 1.0
 */
public class PowerOfGman {

    public static void main(String[] args) {
        try {
            ConsumptionCostModel consumptionCostModel = new ConsumptionCostModel(200, 10, 5);
            List<String> inputs = DriverCodeUtil.readInputs(args[0]);
            DriverCodeUtil.processResults(inputs, consumptionCostModel);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
