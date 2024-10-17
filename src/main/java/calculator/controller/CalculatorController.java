package calculator.controller;


import calculator.model.Calculator;
import calculator.service.DelimiterService;
import calculator.service.NumberExtractorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final DelimiterService delimiterService;
    private final NumberExtractorService numberExtractorService;

    public CalculatorController(DelimiterService delimiterService, NumberExtractorService numberExtractorService) {
        this.delimiterService = delimiterService;
        this.numberExtractorService = numberExtractorService;
    }

    public void start() {
        InputView.printStartMessage();
        String inputString = InputView.getInput();
        inputString = delimiterService.addCustomDelimiters(inputString);
        numberExtractorService.extractNumber(inputString);
        int result = calculatorService
        OutputView.printResultMessage(result);
    }
}