package calculator;

import calculator.controller.CalculatorController;
import calculator.service.StringParser;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        StringParser stringParser = new StringParser();
        CalculatorController calculatorController = new CalculatorController(inputView, stringParser);

        calculatorController.run();
    }
}
