package controller;

import model.CalculatorDate;
import model.CalculatorModel;
import view.CalculatorView;

public class CalculatorController {
    private final CalculatorView view;
    private final CalculatorModel model;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;

    }

    public void startCalculator() {
        String userInput = view.getInput();

        if (userInput.isEmpty()) {
            view.showResult(0);
            return;
        }

        CalculatorDate date = new CalculatorDate(userInput);
        int result = model.calculate(date);
        view.showResult(result);
    }
}
