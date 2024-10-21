package calculator.controller;

import calculator.service.CalculatorService;
import calculator.service.Parser;
import calculator.view.OutputView;

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
        calculatorService.sum(parser.parse(input))
                .ifPresentOrElse(
                        outputView::printResult,
                        () -> outputView.printResult(0)
                );
    }
}
