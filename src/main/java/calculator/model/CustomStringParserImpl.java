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
}
