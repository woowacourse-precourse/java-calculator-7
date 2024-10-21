package calculator.controller;

import calculator.model.Expression;
import calculator.service.CalculatorModel;
import calculator.view.CalculateView;

public class CalculatorController {
    private final CalculatorModel model;
    private final CalculateView view;

    public CalculatorController(CalculatorModel model, CalculateView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        String expression = view.getUserInput();

        Expression expressionModel = new Expression(expression);
        int result = model.calculate(expressionModel);

        view.displayResult(result);
    }
}
