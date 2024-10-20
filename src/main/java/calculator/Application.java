package calculator;


import static calculator.service.DelimiterParser.parseDelimiters;

import calculator.controller.CalculatorController;
import calculator.dto.CalculatorRequest;
import calculator.service.CalculatorService;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        CalculatorController calculatorController = new CalculatorController(calculatorService);

        String userInput = InputView.view();
        CalculatorRequest request = parseDelimiters(userInput);
        calculatorController.calculate(request);
    }
}
