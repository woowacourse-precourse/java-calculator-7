package calculator;

import calculator.customSeparatorExtractor.CustomSeparatorExtractorImpl;
import calculator.io.InputOutputHandler;
import calculator.io.InputParser;
import calculator.io.InputValidator;
import calculator.numberExtractor.NumberExtractorImpl;

public class ApplicationFactory {
    private InputOutputHandler inputOutputHandler;
    private StringCalculator stringCalculator;

    public ApplicationFactory() {
        createInputOutputHandler();
        createStringCalculator();
    }

    private void createInputOutputHandler() {
        InputValidator inputValidator = new InputValidator();
        InputParser inputParser = new InputParser();
        this.inputOutputHandler = new InputOutputHandler(inputValidator, inputParser);
    }

    private void createStringCalculator() {
        CustomSeparatorExtractorImpl customSeparatorExtractor = new CustomSeparatorExtractorImpl();
        NumberExtractorImpl numberExtractor = new NumberExtractorImpl();
        Calculator calculator = new Calculator();
        this.stringCalculator = new StringCalculator(customSeparatorExtractor, numberExtractor, calculator);
    }

    public InputOutputHandler getInputOutputHandler() {
        return inputOutputHandler;
    }

    public StringCalculator getStringCalculator() {
        return stringCalculator;
    }
}
