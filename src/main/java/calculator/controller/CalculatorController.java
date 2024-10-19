package calculator.controller;

import calculator.service.CalculatorService;
import calculator.viiew.CalculatorView;
import java.util.List;

public class CalculatorController {

    public final CalculatorService calculatorService;
    public final CalculatorView calculatorView;

    public CalculatorController(CalculatorService calculatorService, CalculatorView calculatorView) {
        this.calculatorService = calculatorService;
        this.calculatorView = calculatorView;
    }

    public void calculate() {
        String input = calculatorView.input();
        String[] strings = calculatorService.paresInput(input);
        List<Integer> parseInput = calculatorService.convertToNumbers(strings);
        int calculateSum = calculatorService.calculateSum(parseInput);
        calculatorView.resultOutput(calculateSum);
    }
}
