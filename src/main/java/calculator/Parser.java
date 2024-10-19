package calculator;

public class Parser {
    public static void parse(String input) {
        checkDelimiterType(input.charAt(0));
        handleByType(input);
    }

    public static void handleByType(String input) {
        if (Calculator.getIsCustomDelimiter() == true) {
            handleDefaultDelimiter(input);
        }
        else {
            handleCustomDelimiter(input);
        }
    }

    public static void handleDefaultDelimiter(String input) {
        if (Validator.isValidCustomDelimiter(input) == false)
            throw new IllegalArgumentException("Format is invalid.");
        extractCustomDelimiter(input);
    }

    public static void handleCustomDelimiter(String input) {
        if (Validator.isValidDefaultDelimiterString(input) == false)
            throw new IllegalArgumentException("Format is invalid.");
    }

    public static void checkDelimiterType(char firstChar) {
        boolean value = !(Character.isDigit(firstChar) || firstChar == '+' || firstChar == '-');
        Calculator.setIsCustomDelimiter(value);
    }

    public static void extractCustomDelimiter(String input) {
        Calculator.setCustomDelimiter(input.charAt(2));
    }
}
