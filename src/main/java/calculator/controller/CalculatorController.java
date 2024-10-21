package calculator.controller;

public class CalculatorController {
    private static CalculatorController calculatorController;

    private CalculatorController() {
    }

    public static CalculatorController getInstance() {
        if (calculatorController == null) {
            calculatorController = new CalculatorController();
        }
        return calculatorController;
    }

}
