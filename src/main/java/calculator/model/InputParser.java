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
        if (input.isEmpty()) {
            return new String[]{};
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
        String delimiter = input.substring(delimiterStart, delimiterEnd);
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CUSTOM_DELIMITER.getMessage());
        }

        return delimiter;
    }

    private String[] splitInput(String input) {
        String delimitersPattern = "[" + String.join("", delimiterHandler.getDelimiters()).replaceAll("([\\W])", "\\\\$1") + "]";
        return Arrays.stream(input.split(delimitersPattern))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
