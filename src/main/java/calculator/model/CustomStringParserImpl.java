package calculator.model;

import calculator.view.Message;

public class CustomStringParserImpl implements CustomStringParser {

    private final DelimiterManager delimiterManager;

    public CustomStringParserImpl(DelimiterManager delimiterManager) {
        this.delimiterManager = delimiterManager;
    }

    @Override
    public String parse(String input) {
        int customDelimiterStart = input.indexOf("//");
        int customDelimiterEnd = input.indexOf("\\n");

        if (customDelimiterStart == 0 && customDelimiterEnd > 0) {
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

        if ((customDelimiterStart >= 0 && customDelimiterEnd == -1) || (customDelimiterStart == -1
                && customDelimiterEnd >= 0)) {
            throw new IllegalArgumentException(Message.INVALID_DELIMITER_POSITION.getMessage());
        }

        if (customDelimiterStart > customDelimiterEnd) {
            throw new IllegalArgumentException(Message.INVALID_DELIMITER_ORDER.getMessage());
        }

        return input;
    }

    @Override
    public boolean isNumeric(String strNum) {
        if (strNum == null || strNum.isEmpty()) {
            return false;
        }

        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }
}
