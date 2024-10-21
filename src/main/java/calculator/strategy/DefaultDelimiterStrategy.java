package calculator.strategy;

import calculator.util.DelimiterConstants;

public class DefaultDelimiterStrategy implements DelimiterStrategy {
    @Override
    public String[] getDelimiters() {
        return DelimiterConstants.DEFAULT_DELIMITERS;
    }

    @Override
    public String extractNumberPart(String input) {
        return input;
    }
}
