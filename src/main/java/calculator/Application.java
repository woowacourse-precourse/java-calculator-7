package calculator;

import calculator.controller.Calculator;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Calculator calculator = new Calculator(inputView);

        calculator.run();
    }
}
