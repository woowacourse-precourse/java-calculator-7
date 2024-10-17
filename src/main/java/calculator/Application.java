package calculator;

import calculator.application.CalculatorService;
import calculator.ui.CalculatorController;
import calculator.ui.CalculatorPresenter;

public class Application {

    public static void main(String[] args) {
        CalculatorPresenter calculatorPresenter = new CalculatorPresenter(new StringBuilder());
        CalculatorService calculatorService = new CalculatorService();
        CalculatorController calculatorController = new CalculatorController(calculatorPresenter, calculatorService);

        calculatorController.stringAdditionCalculate();
    }

}
