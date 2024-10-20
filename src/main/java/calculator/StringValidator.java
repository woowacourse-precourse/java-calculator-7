package calculator;

public class StringValidator {
    private static final String DEFAULT_DELIMITER = ",|:";

    public String validateAndProcess(String input) {
        if (isEmpty(input)) {
            return "0";
        }

        if (isSinglePositiveNumber(input)) {
            return input;
        }

        String delimiter = determineDelimiter(input);
        String numbersString = extractNumbersString(input);

        return validateNumbers(numbersString, delimiter);
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private boolean isCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private String extractCustomDelimiter(String input) {
        int delimiterSeparatorIndex = input.indexOf("\n");
        if (delimiterSeparatorIndex <= 2) {
            throw new IllegalArgumentException();
        }

        String delimiter = input.substring(2, delimiterSeparatorIndex);
        if (isNumeric(delimiter)) {
            throw new IllegalArgumentException();
        }

        return delimiter;
    }

    private String determineDelimiter(String input) {
        if (isCustomDelimiter(input)) {
            return extractCustomDelimiter(input);
        }
        return DEFAULT_DELIMITER;
    }

    private String extractNumbersString(String input) {
        if (isCustomDelimiter(input)) {
            int delimiterSeparatorIndex = input.indexOf("\n");
            return input.substring(delimiterSeparatorIndex + 1);
        }
        return input;
    }

    private String validateNumbers(String input, String delimiter) {
        String[] numbers = input.split(delimiter);
        for (String number : numbers) {
            parsePositiveInt(number.trim());
        }
        return input;
    }

    private boolean isSinglePositiveNumber(String input) {
        try {
            parsePositiveInt(input.trim());
            return !input.contains(",") && !input.contains(":");
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private int parsePositiveInt(String number) {
        int value = Integer.parseInt(number);
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    private boolean isNumeric(String text) {
        return text.chars().allMatch(Character::isDigit);
    }
}