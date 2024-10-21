package calculator.model;

import calculator.view.Message;

public class CustomDelimiterParserImpl implements CustomDelimiterParser {

    private final DelimiterManager delimiterManager;

    public CustomDelimiterParserImpl(DelimiterManager delimiterManager) {
        this.delimiterManager = delimiterManager;
    }

    @Override
    public String parse(String input) {
        int customDelimiterStart = input.indexOf("//");
        int customDelimiterEnd = input.indexOf("\\n");

        if (customDelimiterStart == 0 && customDelimiterEnd > 0) {
            return getString(input, customDelimiterStart, customDelimiterEnd);
        }

        if ((customDelimiterStart >= 0 && customDelimiterEnd == -1) || (customDelimiterStart == -1
                && customDelimiterEnd >= 0)) {
            throw new IllegalArgumentException(Message.INVALID_DELIMITER_POSITION.getMessage());
        }

        if (customDelimiterStart > customDelimiterEnd) {
            return getString(input, customDelimiterEnd, customDelimiterStart);
        }

        return input;
    }

    @Override
    public String getString(String input, int customDelimiterStart, int customDelimiterEnd) {
        String customDelimiter = input.substring(customDelimiterStart + 2, customDelimiterEnd);

        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException(Message.INCLUDE_NOT_NUMBER.getMessage() + "//\\n");
        }

        if (customDelimiter.length() > 1) {
            throw new IllegalArgumentException(Message.ONLY_ONE_CUSTOM_DELIMITER.getMessage());
        }

        if (isNumeric(customDelimiter)) {
            throw new IllegalArgumentException(Message.INVALID_NUMERIC_CUSTOM_DELIMITER.getMessage());
        }

        delimiterManager.addDelimiter(customDelimiter);

        return input.substring(customDelimiterEnd + 2).trim();
    }

    @Override
    public boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }
}
