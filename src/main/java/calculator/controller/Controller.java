package calculator.controller;

import calculator.service.CalculatorService;
import calculator.service.CustomDelimiterService;
import calculator.service.NumberExtractionService;
import calculator.view.OutputView;

public class Controller {
    private final CustomDelimiterService customDelimiterService;
    private final NumberExtractionService numberExtractionService;
    private final CalculatorService calculatorService;


    public Controller(CustomDelimiterService customDelimiterService, NumberExtractionService numberExtractionService,
                      CalculatorService calculatorService) {
        this.customDelimiterService = customDelimiterService;
        this.numberExtractionService = numberExtractionService;
        this.calculatorService = calculatorService;
    }

    public void run(String inputString) {
        String processedString = customDelimiterProgress(inputString);
        numberExtractProgress(processedString);
        int result = calculateProgress();
        OutputView.printResultMessage(result);
    }

    private String customDelimiterProgress(String inputString) {
        return customDelimiterService.addCustomDelimiters(inputString);
    }

    private void numberExtractProgress(String inputString) {
        numberExtractionService.extractNumber(inputString);
    }

    private int calculateProgress() {
        return calculatorService.calculate();
    }

}