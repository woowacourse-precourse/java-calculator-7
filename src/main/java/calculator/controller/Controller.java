package calculator.controller;

import calculator.model.Equation;
import calculator.view.View;

public class Controller {
    public Controller(View view) {
        String expression = view.inputExpression();
        Equation equation = new Equation(expression);
        int sum = equation.sum();
        view.printCalculateResult(sum);
    }
}
