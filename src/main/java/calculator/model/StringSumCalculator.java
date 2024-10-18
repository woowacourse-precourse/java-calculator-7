package calculator.model;

import java.util.List;

public class StringSumCalculator implements Calculator {

    private static final int DEFAULT_VALUE = 0;
    private final DelimiterManager delimiterManager;
    private final StringParser stringParser;

    public StringSumCalculator(DelimiterManager delimiterManager, StringParser stringParser) {
        this.delimiterManager = delimiterManager;
        this.stringParser = stringParser;
    }

    @Override
    public int calculate(String inputValue) {
        if (inputValue.isEmpty()) {
            return DEFAULT_VALUE;
        }

        if (delimiterManager.existCustomDelimiter(inputValue)) {
            delimiterManager.registerCustomDelimiters(inputValue);
            targetValue = stringParser.splitTarget(inputValue);
        }
        List<Integer> extractedNumbers = stringParser.parseToNumbers(targetValue);
        return 0;
    }
}
