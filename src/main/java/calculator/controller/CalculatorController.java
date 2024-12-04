package calculator.controller;

import calculator.domain.CalculatorInput;
import calculator.service.CalculatorService;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
    }

    public void run() {
        try {
            String input = getUserInput();
            CalculatorInput calculatorInput = new CalculatorInput(input);
            int result = calculatorService.calculate(calculatorInput);
            displayResult(result);
        } catch (Exception e) {
            displayError(e.getMessage());
            throw e;
        }
    }

    private String getUserInput() {
        System.out.println("Enter numbers to calculate:");
        return Console.readLine();
    }

    private void displayResult(int result) {
        System.out.println("결과 : " + result);
    }

    private void displayError(String message) {
        System.out.println("Error: " + message);
    }
}
