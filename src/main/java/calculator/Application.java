package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.DelimiterParser;
import calculator.model.InputValidator;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        //TODO 의존관계 주입 더 나은 방법있는지 리팩터링 확인
        InputValidator inputValidator = new InputValidator();
        DelimiterParser delimiterParser = new DelimiterParser(inputValidator);
        Calculator calculator = new Calculator(inputValidator, delimiterParser);
        CalculatorView calculatorView = new CalculatorView();

        CalculatorController calculatorController = new CalculatorController(calculator, calculatorView);
        calculatorController.run();

    }
}
