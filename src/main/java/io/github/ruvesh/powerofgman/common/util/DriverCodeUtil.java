package io.github.ruvesh.powerofgman.common.util;

import io.github.ruvesh.powerofgman.common.constant.StringConstants;
import io.github.ruvesh.powerofgman.service.model.ConsumptionCostModel;
import io.github.ruvesh.powerofgman.entity.GMan;
import io.github.ruvesh.powerofgman.service.ConsumptionEvaluator;
import io.github.ruvesh.powerofgman.service.PowerConsumptionEvaluator;
import io.github.ruvesh.powerofgman.service.model.Coordinate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Utility Class for the Driver code for the application
 *
 * @author ruvesh
 * @since 1.0
 */
public class DriverCodeUtil {

    /**
     * Do not allow instance creation
     */
    private DriverCodeUtil() {
    }

    /**
     * Reads inputs from provided input file and processes the result
     *
     * @param filePath             the path to the sample input file
     * @param consumptionCostModel holds information about the parameters of consumption cost for the character's moves
     */
    public static void readInputsAndProcessResults(String filePath, ConsumptionCostModel consumptionCostModel) throws IOException{
        GMan gMan = new GMan();
        FileInputStream fis = new FileInputStream(filePath);
        Scanner sc = new Scanner(fis);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] cmd = input.split(StringConstants.SPACE);
            switch (cmd[0]) {
                case StringConstants.SOURCE:
                    Coordinate sourceCoordinate = new Coordinate(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    gMan.setSourceCoordinate(sourceCoordinate);
                    gMan.setDirectionFacing(cmd[3]);
                    break;
                case StringConstants.DESTINATION:
                    Coordinate destinationCoordinate = new Coordinate(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    gMan.setDestinationCoordinate(destinationCoordinate);
                    break;
                case StringConstants.PRINT_POWER:
                    int remainingPower = calculateRemainingPower(gMan, consumptionCostModel);
                    System.out.println(StringConstants.POWER + StringConstants.SPACE + remainingPower);
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }

    /**
     * Calculates the remaining power after the moves are made as per the inputs provided
     *
     * @param gMan                 represents the details of the characters current position, direction and destination position
     * @param consumptionCostModel holds information about the parameters of consumption cost for the character's moves
     * @return remaining power after the moves are made
     */
    private static int calculateRemainingPower(GMan gMan, ConsumptionCostModel consumptionCostModel) {
        ConsumptionEvaluator powerConsumptionEvaluator = new PowerConsumptionEvaluator();
        return consumptionCostModel.getTotalPower() - powerConsumptionEvaluator.evaluateConsumption(gMan.getSourceCoordinate(), gMan.getDestinationCoordinate(), gMan.getDirectionFacing(), consumptionCostModel);
    }

}
