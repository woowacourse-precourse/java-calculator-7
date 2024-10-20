package calculator.controller;

import calculator.service.CalculatorService;
import calculator.service.Parser;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {
    private final CalculatorService calculatorService;
    private final Parser parser;
    private final OutputView outputView;

    public CalculatorController(CalculatorService calculatorService, Parser parser, OutputView outputView) {
        this.calculatorService = calculatorService;
        this.parser = parser;
        this.outputView = outputView;
    }

    public void run(String input) {
        List<Integer> numbers = parser.parse(input);

        int result = calculatorService.sum(numbers)
                .orElse(0);

        outputView.printResult(result);
    }
}
