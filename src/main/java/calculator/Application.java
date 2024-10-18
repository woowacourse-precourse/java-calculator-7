package calculator;

import calculator.controller.CalculatorController;
import calculator.view.CalculatorRequest;

public class Application {
    public static void main(String[] args) {
        CalculatorRequest calculatorRequest = new CalculatorRequest();
        CalculatorController calculatorController = new CalculatorController();

        calculatorRequest.getStartMessage();
        calculatorController.calculateSum(calculatorRequest.inputString());


    }
}
