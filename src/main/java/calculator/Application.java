package calculator;

import calculator.controller.CalculatorController;
import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        CalculatorView calculatorView = new CalculatorView();
        CalculatorModel calculatorModel = new CalculatorModel();
        CalculatorController calculatorController = new CalculatorController(calculatorView, calculatorModel);

        calculatorController.start();
    }
}
