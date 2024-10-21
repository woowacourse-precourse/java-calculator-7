package calculator.controller;

import calculator.domain.Expression;
import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {
    private final CalculatorView view = new CalculatorView();
    private final CalculatorService calculator = new CalculatorService();

    public void run(){
        Expression expression = new Expression(view.getInput());
        view.showResult(calculator.calculate(expression));
    }
}
