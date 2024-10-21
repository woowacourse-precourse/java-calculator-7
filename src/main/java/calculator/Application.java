package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView input = new InputView();
        Calculator calculator = new Calculator();
        new OutputView(calculator.add(input.getUserInput()));
    }
}