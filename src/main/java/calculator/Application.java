package calculator;

import calculator.controller.CalculatorController;
import calculator.model.StringCalculator;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        new CalculatorController(new StringCalculator(), new CalculatorView()).run();
    }
}
