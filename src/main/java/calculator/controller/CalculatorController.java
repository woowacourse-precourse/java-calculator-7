package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {
    private final CalculatorView view = new CalculatorView();
    private final CalculatorService calculator = new CalculatorService();

    public void run(){
        String input = view.getInput();
        view.showResult(calculator.add(input));
    }
}
