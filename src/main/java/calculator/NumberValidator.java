package calculator;

public class NumberValidator {
    private static final String NEGATIVE_SIGN = "-";
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String NEGATIVE_ERROR_MESSAGE = "문자열에 음수가 포함되어 있습니다.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "문자열에 숫자가 아닌 문자가 포함되어 있습니다.";

    public static void validate(String number) {
        if (NumberValidator.isNegative(number)) {
            throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
        }
        if (!NumberValidator.isNumber(number)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private static boolean isNegative(String number) {
        return number.startsWith(NEGATIVE_SIGN);
    }

    private static boolean isNumber(String number) {
        return number.matches(NUMBER_REGEX);
    }
}
