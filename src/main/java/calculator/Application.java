package calculator;

import calculator.controller.CalculatorController;
import calculator.service.StringCalculatorService;
import calculator.service.StringCalculatorServiceImpl;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {

        StringCalculatorService calculatorService = new StringCalculatorServiceImpl();
        CalculatorController calculatorController = new CalculatorController(calculatorService);

        while (true) {
            String input = CalculatorView.getInput();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            calculatorController.processInput(input);
        }
    }
}
