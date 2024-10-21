package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;

public class CalculatorController {
    private final CalculatorService service;
    private final InputView view;

    public CalculatorController() {
        this.service = new CalculatorService();
        this.view = new InputView();
    }

    public void run() {
        String input = view.getInput();
        try {
            int result = service.add(input);
            view.showResult(result);
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }
}
