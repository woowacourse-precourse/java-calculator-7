package calculator;

import calculator.controller.CalculationController;

public class Application {

    public static void main(String[] args) {
        CalculationController calculationController = new CalculationController();
        calculationController.run();
    }
}
