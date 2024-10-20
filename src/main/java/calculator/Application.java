package calculator;

import calculator.controller.CalculatorController;
import calculator.model.StringCalculator;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        CalculatorView CalculatorView = new CalculatorView();
        CalculatorController controller = new CalculatorController(stringCalculator, CalculatorView);

        controller.run();
    }
}
