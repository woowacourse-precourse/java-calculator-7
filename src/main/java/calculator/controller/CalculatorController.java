package calculator.controller;

import calculator.model.Calculator;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final Calculator calculator;
    private final CalculatorView view;

    public CalculatorController(Calculator calculator, CalculatorView view) {
        this.calculator = calculator;
        this.view = view;
    }

    public void run() {
        while (true) {
            String input = view.getInput();

            if (input.equalsIgnoreCase("end")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            int result = calculator.calculate(input);
            view.showResult(result);
        }
    }
}
