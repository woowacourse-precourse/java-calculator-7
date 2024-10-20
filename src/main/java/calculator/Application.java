package calculator;

import calculator.controller.CalculatorController;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {

        CalculatorView calcView = new CalculatorView();
        CalculatorController calcController = new CalculatorController(calcView);

        calcController.start();
    }
}
