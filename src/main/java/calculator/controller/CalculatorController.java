package calculator.controller;

import calculator.model.Expression;
import calculator.service.Calculator;
import calculator.view.CalculateView;

public class CalculatorController {
    private final Calculator model;
    private final CalculateView view;

    public CalculatorController(Calculator model, CalculateView view) {
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
