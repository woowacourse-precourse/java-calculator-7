package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        CalculatorController calculatorController = new CalculatorController(new CalculatorService(), new InputView());

        calculatorController.start();
    }
}

