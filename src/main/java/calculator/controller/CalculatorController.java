package calculator.controller;

import calculator.constant.CustomDelimiterPattern;
import calculator.model.Calculator;
import calculator.model.DelimiterManager;
import calculator.model.StringSplitter;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final StringSplitter stringSplitter;
    private final Calculator calculator;
    private final DelimiterManager delimiterManager;
    private static final String PREFIX = CustomDelimiterPattern.PREFIX.getSymbol();
    private static final String SUFFIX = CustomDelimiterPattern.SUFFIX.getSymbol();
    private static final int NOT_FOUND = -1;
    private static final String MINUS = "-";
    private boolean allowNegativeNumbers;
    private List<String> delimiters;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.stringSplitter = new StringSplitter();
        this.calculator = new Calculator();
        this.delimiterManager = new DelimiterManager();
        this.allowNegativeNumbers = false;
    }

    public void run() {
        String inputString = inputView.readStringToAdd();

        String numbersToAddition = extractStringWithoutPattern(inputString);

        configureDelimitersAndNegativeNumberAllowance();

        List<Integer> extractedNumbers = splitNumbers(numbersToAddition);

        int result = calculator.calculateResult(extractedNumbers);
        outputView.printAdditionResult(result);
    }

    private String extractStringWithoutPattern(String inputString) {
        String numbersToAddition = inputString;
        if (inputString.startsWith(PREFIX)) {
            delimiterManager.addCustomDelimiter(inputString);
            numbersToAddition = extractNumbersAfterCustomDelimiter(inputString);
        }
        return numbersToAddition;
    }

    private String extractNumbersAfterCustomDelimiter(String inputString) {
        String customDelimiter = SUFFIX;
        int endOfPatternIndex = inputString.indexOf(customDelimiter);

        if (endOfPatternIndex != NOT_FOUND) {
            return inputString.substring(endOfPatternIndex + customDelimiter.length());
        } else {
            return inputString;
        }
    }

    private void configureDelimitersAndNegativeNumberAllowance() {
        delimiters = delimiterManager.getAllDelimiters();

        if (delimiters.contains(MINUS)) {
            allowNegativeNumbers = true;
        }
    }

    private List<Integer> splitNumbers(String numbersToAddition) {
        return stringSplitter.splitAndConvertToIntegers(numbersToAddition, delimiters, allowNegativeNumbers);
    }
}
