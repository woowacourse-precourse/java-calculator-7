package calculator.util;

public class Validator {
    private static final String CUSTOM_REG_END = "\\n";

    public static void validateCustomRegex(String target) {
        if (!target.contains(CUSTOM_REG_END)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateWrongNumber(String number) {
        validateIsWrongNumber(number);
        validateIsMinusNumber(number);
    }

    private static void validateIsWrongNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIsMinusNumber(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException();
        }
    }
}
