package calculator.controller;

import calculator.model.Calculator;
import calculator.model.CustomDelimiterProcessor;
import calculator.model.Delimiters;
import calculator.model.NumberExtractor;
import calculator.model.Numbers;
import calculator.view.OutputView;

public class Controller {
    private final CustomDelimiterProcessor customDelimiterProcessor;
    private final NumberExtractor numberExtractor;
    private final Calculator calculator;

    public Controller(CustomDelimiterProcessor customDelimiterProcessor, NumberExtractor numberExtractor,
                      Calculator calculator) {
        this.customDelimiterProcessor = customDelimiterProcessor;
        this.numberExtractor = numberExtractor;
        this.calculator = calculator;
    }

    public void run(String inputString) {
        Delimiters delimiters = new Delimiters();
        String processedString = customDelimiterProgress(inputString, delimiters);

        Numbers numbers = numberExtractProgress(processedString, delimiters);

        int result = calculateProgress(numbers);

        OutputView.printResultMessage(result);
    }

    private String customDelimiterProgress(String inputString, Delimiters delimiters) {
        return customDelimiterProcessor.addCustomDelimiters(inputString, delimiters);
    }

    private Numbers numberExtractProgress(String inputString, Delimiters delimiters) {
        return numberExtractor.extractNumber(inputString, delimiters);
    }

    private int calculateProgress(Numbers numbers) {
        return calculator.calculate(numbers);
    }

}