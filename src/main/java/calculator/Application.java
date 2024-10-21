package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(calculator, view);
        controller.run(); // 프로그램 실행
    }
}