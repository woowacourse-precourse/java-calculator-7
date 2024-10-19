package calculator;

import calculator.controller.CustomCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CustomCalculator calculator = new CustomCalculator(new InputView(), new OutputView());
        calculator.run();
    }
}
