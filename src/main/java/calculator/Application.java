package calculator;

import calculator.controller.CalculatorController;
import calculator.view.CalculatorView;

public class Application {

    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(view);

        controller.run();
    }
}
