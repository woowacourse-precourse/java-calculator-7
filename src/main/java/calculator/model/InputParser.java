package calculator.model;

import calculator.common.ErrorMessage;
import java.util.Arrays;

public class InputParser {
    private final DelimiterHandler delimiterHandler;

    public InputParser(DelimiterHandler delimiterHandler) {
        this.delimiterHandler = delimiterHandler;
    }

    public String[] parseInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT.getMessage());
        }
        if (input.indexOf("//") != input.lastIndexOf("//")) {
            throw new IllegalArgumentException(ErrorMessage.MULTIPLE_CUSTOM_DELIMITERS.getMessage());
        }
        if (input.contains(",,") || input.contains("::")) {
            throw new IllegalArgumentException(ErrorMessage.CONSECUTIVE_DELIMITERS.getMessage());
        }
        if (input.startsWith("//")) {
            String delimiter = extractCustomDelimiter(input);
            delimiterHandler.addCustomDelimiter(delimiter);
            input = input.substring(input.indexOf("\n") + 1);
        }
        return splitInput(input);
    }

    private String extractCustomDelimiter(String input) {
        int delimiterStart = input.indexOf("//") + 2;
        int delimiterEnd = input.indexOf("\n");
        if (delimiterEnd < delimiterStart) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_POSITION.getMessage());
        }
        return input.substring(delimiterStart, delimiterEnd);
    }

    private String[] splitInput(String input) {
        String delimitersPattern = "[" + String.join("", delimiterHandler.getDelimiters()) + "]";
        return Arrays.stream(input.split(delimitersPattern))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
