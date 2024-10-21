package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.view.CalculateView;

public class Application {
    public static void main(String[] args) {
        Calculator model = new Calculator();
        CalculateView view = new CalculateView();
        CalculatorController controller = new CalculatorController(model, view);

        controller.run();
    }
}

