package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.SumCalculator;
import calculator.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        SumCalculator calculator = new SumCalculator();

        CalculatorController calculatorController = new CalculatorController(view, calculator);

        calculatorController.run();
    }
}
