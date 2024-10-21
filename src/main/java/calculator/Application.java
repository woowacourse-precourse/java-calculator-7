package calculator;

import calculator.factory.FlowFactory;
import calculator.controller.CalculationController;

public class Application {
    public static void main(String[] args) {
        CalculationController calculationFlow = FlowFactory.createCalculationFlow();
        calculationFlow.run();
    }
}
