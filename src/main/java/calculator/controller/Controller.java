package calculator.controller;

import calculator.service.CalculatorService;
import calculator.service.CustomDelimiterService;
import calculator.service.NumberExtractionService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {
    private final CustomDelimiterService customDelimiterService;
    private final NumberExtractionService numberExtractionService;
    private final CalculatorService calculatorService;

    private String inputString;
    private String processedString;
    private int result;

    public Controller(CustomDelimiterService customDelimiterService, NumberExtractionService numberExtractionService,
                      CalculatorService calculatorService) {
        this.customDelimiterService = customDelimiterService;
        this.numberExtractionService = numberExtractionService;
        this.calculatorService = calculatorService;
    }

    public void run() {
        start();
        progress();
        finish();
    }

    private void start() {
        InputView.printStartMessage();
        inputString = InputView.getInput();
    }

    private void progress() {
        customDelimiterProgress();
        numberExtractProgress();
        calculateProgress();
    }

    private void customDelimiterProgress() {
        processedString = customDelimiterService.addCustomDelimiters(inputString);
    }

    private void numberExtractProgress() {
        numberExtractionService.extractNumber(processedString);
    }

    private void calculateProgress() {
        result = calculatorService.calculate();
    }


    private void finish() {
        OutputView.printResultMessage(result);
    }

}