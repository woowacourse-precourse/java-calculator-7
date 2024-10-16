package calculator.controller;

import calculator.domain.DelimiterSet;
import calculator.domain.Numbers;
import calculator.domain.OriginalString;
import calculator.io.InputManager;
import calculator.io.OutputManager;
import calculator.service.DelimiterExtractor;
import calculator.service.NumberCalculator;
import calculator.service.StringParser;

public class Controller {

    private final DelimiterExtractor delimiterExtractor;
    private final StringParser stringParser;
    private final NumberCalculator numberCalculator;

    public Controller(DelimiterExtractor delimiterExtractor, StringParser stringParser,
                      NumberCalculator numberCalculator) {
        this.delimiterExtractor = delimiterExtractor;
        this.stringParser = stringParser;
        this.numberCalculator = numberCalculator;
    }

    public void run() {
        OriginalString originalString = InputManager.readInput();
        DelimiterSet delimiterSet = delimiterExtractor.extractDelimiter(originalString.value());

        String numberPart = stringParser.parseInput(originalString, delimiterSet.hasCustom());
        Numbers numbers = numberCalculator.calculateNumbers(numberPart, delimiterSet.getSplitForm());

        OutputManager.printSum(numbers.getSum());
    }

}
