package calculator;

public class Validator {
    private static final String WRONG_CHARACTER_ERROR_MESSAGE = "잘못된 문자 포함됨";
    private static final String WRONG_DELIMITER_ERROR_MESSAGE = "잘못된 커스텀 구분자";

    public void validateDefaultInput(String input) {
        String regex = "^[0-9:,]*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(WRONG_CHARACTER_ERROR_MESSAGE);
        }
    }

    public void validateCustomInput(String input, String customDelimiter) {
        String regex = "^([0-9:,]+|(" + customDelimiter + "))*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(WRONG_CHARACTER_ERROR_MESSAGE);
        }
    }

    public static boolean isEmptyString(String input) {
        return input == null || input.isEmpty();
    }

    public static void validateCustomDelimiter(String input) {
        if (isNumeric(input)) {
            throw new IllegalArgumentException(WRONG_DELIMITER_ERROR_MESSAGE);
        }
    }

    private static boolean isNumeric(String input) {
        return input.matches(".*[0-9].*");
    }
}
