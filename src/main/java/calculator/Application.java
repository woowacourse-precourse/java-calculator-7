package calculator;

import calculator.controller.CalculatorController;
import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;

public class Application {

    public static void main(String[] args) {
        CalculatorModel calculatorModel = new CalculatorModel();
        CalculatorView calculatorView = new CalculatorView();
        CalculatorController calculatorController = new CalculatorController(calculatorModel, calculatorView);
        calculatorController.run();
    }
}
