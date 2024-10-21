package calculator;


import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.Validator;
import calculator.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        Calculator calculator = new Calculator();
        Validator validator = new Validator();
        CalculatorController controller = new CalculatorController(calculator, validator, view);

        controller.run();

    }
}

