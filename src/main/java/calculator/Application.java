package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.CalculatorInputView;
import calculator.view.CalculatorOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorInputView inputView = new CalculatorInputView();
        CalculatorService calculatorService = new CalculatorService();
        CalculatorOutputView outputView = new CalculatorOutputView();

        CalculatorController calculatorController = new CalculatorController(inputView, calculatorService, outputView);
        calculatorController.run();
    }
}
