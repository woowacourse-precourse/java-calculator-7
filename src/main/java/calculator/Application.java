package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.InputValidator;
import calculator.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator();
        InputValidator validator = new InputValidator();
        ConsoleView view = new ConsoleView();
        CalculatorController controller = new CalculatorController(calculator, validator, view);

        controller.run();  // 프로그램 실행
    }
}
