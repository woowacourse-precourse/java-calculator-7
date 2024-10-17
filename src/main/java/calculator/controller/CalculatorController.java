package calculator.controller;


import calculator.service.CalculatorService;
import calculator.service.DelimiterService;
import calculator.service.NumberExtractorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final DelimiterService delimiterService;
    private final NumberExtractorService numberExtractorService;
    private final CalculatorService calculatorService;

    public CalculatorController(DelimiterService delimiterService, NumberExtractorService numberExtractorService,
                                CalculatorService calculatorService) {
        this.delimiterService = delimiterService;
        this.numberExtractorService = numberExtractorService;
        this.calculatorService = calculatorService;
    }

    public void start() {
        InputView.printStartMessage();
        String inputString = InputView.getInput();
        inputString = delimiterService.addCustomDelimiters(inputString);
        numberExtractorService.extractNumber(inputString);
        int result = calculatorService.calculate();
        OutputView.printResultMessage(result);
    }
}