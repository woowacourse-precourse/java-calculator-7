package calculator.controller;

import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import calculator.view.InputView;

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
        calculatorService.separate(calculator.getSeparators(), expression);
    }
}
