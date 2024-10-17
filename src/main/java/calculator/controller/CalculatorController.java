package calculator.controller;


import calculator.model.CustomDelimiterProcessor;
import calculator.model.NumberExtractor;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final CustomDelimiterProcessor customDelimiterProcessor;
    private final NumberExtractor numberExtractor;

    public CalculatorController(CustomDelimiterProcessor customDelimiterProcessor, NumberExtractor numberExtractor) {
        this.customDelimiterProcessor = customDelimiterProcessor;
        this.numberExtractor = numberExtractor;
    }

    public void start() {
        InputView.printStartMessage();
        String inputString = InputView.getInput();
        inputString = customDelimiterProcessor.addCustomDelimiters(inputString);
        numberExtractor.extractNumber(inputString);
        int result = calculator.calculate();
        OutputView.printResultMessage(result);
    }
}