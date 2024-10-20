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
        String expression = InputView.expression();
        String customSeparator = calculatorService.getCustomSeparator(expression);

        if (customSeparator != null) {
            calculator.addSeparator(customSeparator);
            expression = calculatorService.removeCustomSeparatorDefinition(expression);
        }

        String[] totkens = calculatorService.separate(calculator.getSeparators(), expression);
        int[] number = calculatorService.convertToIntArray(totkens);

        calculator.setNumber(number);
        
        calculator.calc();
        OutputView.executionResult(calculator.getResult());
    }
}
