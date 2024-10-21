package calculator;

import calculator.controller.CalculatorController;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        String input = InputView.getLine();
        CalculatorController controller = new CalculatorController(input);
        controller.run();
    }
}
