package calculator.controller;

import calculator.view.CalculatorView;
import calculator.service.CalculatorService;

public class CalculatorController {

    private final CalculatorView view;
    private final CalculatorService service;

    public CalculatorController() {
        this.view = new CalculatorView();
        this.service = new CalculatorService();
    }

    public void execute() {
        String input = view.getInput();

        view.printOutput(
                service.calculate(input)
        );
    }
}
