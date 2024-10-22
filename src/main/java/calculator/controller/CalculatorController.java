package calculator.controller;

import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import calculator.util.Parser;
import calculator.view.CalculatorInput;
import calculator.view.CalculatorOutput;

public class CalculatorController {

    private final CalculatorService calculatorService;
    private final Parser parser;

    public CalculatorController(CalculatorService calculatorService, Parser parser) {
        this.calculatorService = calculatorService;
        this.parser = parser;
    }

    public void calculate(Calculator calculator) {
        final String input = CalculatorInput.inputString();
        parser.parsing(calculator, input);
        final Long result = calculatorService.getSumResult(calculator);
        CalculatorOutput.outputResult(result);
    }
}
