package calculator.controller;

import calculator.model.Expression;
import calculator.model.Operators;
import calculator.service.CalculateService;
import calculator.service.ParseService;
import calculator.view.CalculatorView;
import java.util.ArrayList;
import java.util.List;

public class CalculatorController {
    public void stringAdd() {
        Operators operators = new Operators(new ArrayList<>(List.of(';', ',')));
        Expression expression = new Expression();

        String sentence = CalculatorView.input();
        ParseService.parseExpression(sentence, operators, expression);
        int result = CalculateService.sequentialAdd(operators, expression);
        CalculatorView.output(result);
    }
}
