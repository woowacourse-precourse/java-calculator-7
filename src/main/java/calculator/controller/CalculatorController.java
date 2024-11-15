package calculator.controller;

import calculator.model.Calculator;
import calculator.model.ExpressionParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
    }

    public void calculate() {
        String expression = inputView.readExpression();

        ExpressionParser expressionParser = new ExpressionParser(expression);
        Calculator calculator = new Calculator(expressionParser);

        outputView.printResult(calculator.getResult());

        inputView.closeInputView();
        outputView.closeOutputView();
    }
}
