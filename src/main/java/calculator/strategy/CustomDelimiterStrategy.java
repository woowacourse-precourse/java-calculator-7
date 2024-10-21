package calculator.strategy;

import calculator.util.CustomDelimiterExtractor;
import calculator.util.DelimiterConstants;
import calculator.util.NumberExtractor;

public class CustomDelimiterStrategy implements DelimiterStrategy {
    private final String customDelimiter;

    public CustomDelimiterStrategy(String input) {
        this.customDelimiter = CustomDelimiterExtractor.extract(input);
    }

    @Override
    public String[] getDelimiters() {
        return NumberExtractor.mergeDelimiters(customDelimiter);
    }

    @Override
    public String extractNumberPart(String input) {
        return input.substring(input.indexOf(DelimiterConstants.CUSTOM_DELIMITER_END) + 2);
    }
}