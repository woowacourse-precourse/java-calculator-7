package calculator;

import calculator.controller.CalculatorController;
import calculator.service.StringCalculatorService;
import calculator.service.StringCalculatorServiceImpl;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {

        StringCalculatorService calculatorService = new StringCalculatorServiceImpl();
        CalculatorController calculatorController = new CalculatorController(calculatorService);

        String input = CalculatorView.getInput();
        calculatorController.processInput(input);
    }
}
