package calculator.controller;

import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final Calculator calculator;
    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.calculator = new Calculator();
        this.calculatorService = new CalculatorService();
    }

    public void start() {
        play();
    }

    private void play() {
        String expression = getInputExpression();
        expression = handleCustomSeparator(expression);

        int[] numbers = parseExpressionToNumbers(expression);
        calculator.setNumber(numbers);

        calculator.calc();
        OutputView.executionResult(calculator.getResult());

    }

    private String getInputExpression() {
        return InputView.expression();
    }

    private String handleCustomSeparator(String expression) {
        String customSeparator = getCustomSeparator(expression);
        if (customSeparator != null) {
            addCustomSeparator(customSeparator);
            return getRemovedCustomSeparator(expression);
        }
        return expression;
    }

    private String getCustomSeparator(String expression) {
        return calculatorService.getCustomSeparator(expression);
    }

    private void addCustomSeparator(String separator) {
        calculator.addSeparator(separator);
    }

    private String getRemovedCustomSeparator(String expression) {
        return calculatorService.removeCustomSeparatorDefinition(expression);
    }

    private int[] parseExpressionToNumbers(String expression) {
        String[] tokens = calculatorService.separate(calculator.getSeparators(), expression);
        return calculatorService.convertToIntArray(tokens);
    }
}
