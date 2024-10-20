package calculator;

public class StringValidator {
    public String validateAndProcess(String input) {
        if (isEmpty(input)) {
            return "0";
        }

        if (isSinglePositiveNumber(input)) {
            return input;
        }

        if (isCustomDelimiter(input)) {
            return validateCustomDelimiter(input);
        }

        return validateNumbers(input);
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private boolean isCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private String validateCustomDelimiter(String input) {
        int delimiterSeparatorIndex = input.indexOf("\n");
        if (delimiterSeparatorIndex <= 2) {
            throw new IllegalArgumentException();
        }

        String delimiter = input.substring(2, delimiterSeparatorIndex);
        if (isNumeric(delimiter)) {
            throw new IllegalArgumentException();
        }

        return validateNumbers(input.substring(delimiterSeparatorIndex + 1), delimiter);
    }

    private String validateNumbers(String input) {
        return validateNumbers(input, ",|:");
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
        for (char c : text.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}