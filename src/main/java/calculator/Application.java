package calculator;

import calculator.controller.CalculatorController;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        CalculatorController cal = new CalculatorController(new InputView());
        System.out.println("결과 : " + cal.process());
    }
}
