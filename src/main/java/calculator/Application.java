package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorModel;
import calculator.view.CalculateView;

public class Application {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculateView view = new CalculateView();
        CalculatorController controller = new CalculatorController(model, view);

        controller.run();
    }
}

