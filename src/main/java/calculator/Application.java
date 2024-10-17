package calculator;

import calculator.controller.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator(new InputView(), new OutputView());
        calculator.run();
    }
}
