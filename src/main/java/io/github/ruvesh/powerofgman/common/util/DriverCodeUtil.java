package io.github.ruvesh.powerofgman.common.util;

import io.github.ruvesh.powerofgman.common.constant.StringConstants;
import io.github.ruvesh.powerofgman.service.model.ConsumptionCostModel;
import io.github.ruvesh.powerofgman.entity.GMan;
import io.github.ruvesh.powerofgman.service.ConsumptionEvaluator;
import io.github.ruvesh.powerofgman.service.PowerConsumptionEvaluator;
import io.github.ruvesh.powerofgman.service.model.Coordinate;
import io.github.ruvesh.powerofgman.service.model.GManTrajectory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Utility Class for the Driver code for the application
 *
 * @author ruvesh
 * @since 1.0
 */
public class DriverCodeUtil {

    private DriverCodeUtil() {
    }

    public static List<String> readInputs(String filePath) throws IOException{
        FileInputStream fis = new FileInputStream(filePath);
        Scanner sc = new Scanner(fis);
        List<String> inputLines = new ArrayList<>();
        while (sc.hasNextLine()) {
            inputLines.add(sc.nextLine());
        }
        sc.close();
        return inputLines;
    }

    private static int calculateRemainingPower(GMan gMan, ConsumptionCostModel consumptionCostModel) {
        ConsumptionEvaluator powerConsumptionEvaluator = new PowerConsumptionEvaluator();
        GManTrajectory gManTrajectory = new GManTrajectory(gMan.getSourceCoordinate(), gMan.getDestinationCoordinate(), gMan.getDirectionFacing(), consumptionCostModel);
        return consumptionCostModel.getTotalPower() - powerConsumptionEvaluator.evaluateConsumption(gManTrajectory);
    }

    public static void processResults(List<String> inputs, ConsumptionCostModel consumptionCostModel) {
        GMan gMan = new GMan();
        for(String inputLine: inputs) {
            String[] cmd = inputLine.split(StringConstants.SPACE);
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
    }
}
