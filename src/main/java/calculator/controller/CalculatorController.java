package calculator.controller;

import calculator.model.Expression;
import calculator.model.Operators;
import calculator.service.CalculateService;
import calculator.service.ParseService;
import calculator.view.CalculatorView;
import java.util.ArrayList;
import java.util.List;

public class CalculatorController {
    static public void stringAdd() {
        final List<Character> basicOperator = List.of(';', ',');

        Operators operators = new Operators(new ArrayList<>(basicOperator));
        Expression expression = new Expression();

        String sentence = CalculatorView.input();
        ParseService.parseExpression(sentence, operators, expression);
        int result = CalculateService.sequentialAdd(operators, expression);
        CalculatorView.output(result);
    }
}