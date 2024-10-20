package calculator.controller;

import calculator.model.Calculator;
import calculator.view.MultiView;

public class CalculatorController {
    public void run() {
        String input = MultiView.getInput();
        int result = Calculator.sum(input);
        MultiView.getOutput(result);
    }
}
