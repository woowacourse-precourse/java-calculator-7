package calculator.controller;

import calculator.model.Calculator;
import calculator.model.Expression;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public void run() {
        String input = InputView.getExpression();
        Expression expression = new Expression(input);
        Calculator calculator = new Calculator();
        int result = calculator.run(expression.getExpression());
        OutputView.result(result);
    }
}
