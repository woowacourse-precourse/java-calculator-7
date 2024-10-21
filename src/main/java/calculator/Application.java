package calculator;

import calculator.Controller.CalculatorController;
import calculator.Model.Calculator;
import calculator.View.CalculatorView;

public class Application {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        Calculator model = new Calculator();
        CalculatorController controller = new CalculatorController(model, view);

        controller.run();
    }
}
