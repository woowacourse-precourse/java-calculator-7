package calculator;

import calculator.controller.CalculatorController;
import calculator.service.Calculate;
import calculator.service.StringParser;
import calculator.service.Validator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Validator validator = new Validator();
        StringParser stringParser = new StringParser();
        Calculate calculate = new Calculate();

        CalculatorController calculatorController = new CalculatorController(inputView, outputView, stringParser,
                calculate, validator);

        calculatorController.run();
    }
}
