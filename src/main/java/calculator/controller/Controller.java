package calculator.controller;


import calculator.service.CalculatorService;
import calculator.service.DelimiterService;
import calculator.service.NumberService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {
    private final DelimiterService delimiterService;
    private final NumberService numberService;
    private final CalculatorService calculatorService;

    private String inputString;
    private String processedString;
    private int result;

    public Controller(DelimiterService delimiterService, NumberService numberService,
                      CalculatorService calculatorService) {
        this.delimiterService = delimiterService;
        this.numberService = numberService;
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
        processedString = delimiterService.addCustomDelimiters(inputString);
    }

    private void numberExtractProgress() {
        numberService.extractNumber(processedString);
    }

    private void calculateProgress() {
        result = calculatorService.calculate();
    }


    private void finish() {
        OutputView.printResultMessage(result);
    }

}