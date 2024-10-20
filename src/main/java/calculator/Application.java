package calculator;

import calculator.Controller.CalculatorController;
import calculator.View.CalculatorView;

public class Application {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(view);

        controller.run();
    }
}
