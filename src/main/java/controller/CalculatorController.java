package controller;

import model.CalculatorModel;
import view.CalculatorView;

public class CalculatorController {
    private final CalculatorView view;
    private final CalculatorModel model;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void runController() {
        String input = view.getInput();
        String new_input = model.checkCustomDelimiter(input);

        int result = 0;
        if (!new_input.isEmpty()) {
            model.filterInput(new_input);
            result = model.sumNumber();
        }

        view.displayResult(result);
    }
}
