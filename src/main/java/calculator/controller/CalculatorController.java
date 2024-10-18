package calculator.controller;

import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import calculator.service.ParsingService;
import calculator.view.CalculatorInput;
import calculator.view.CalculatorOutput;

public class CalculatorController {

    private final CalculatorService calculatorService;
    private final ParsingService parsingService;

    public CalculatorController(CalculatorService calculatorService, ParsingService parsingService) {
        this.calculatorService = calculatorService;
        this.parsingService = parsingService;
    }

    public void calculate(Calculator calculator) {
        final String input = CalculatorInput.inputString();
        parsingService.parsing(calculator, input);
        final Long result = calculatorService.getSumResult(calculator);
        CalculatorOutput.outputResult(result);
    }
}
