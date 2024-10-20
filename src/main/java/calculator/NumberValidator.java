package calculator;

public class NumberValidator {
    private static final String NEGATIVE_SIGN = "-";
    private static final String NEGATIVE_ERROR_MESSAGE = "문자열에 음수가 포함되어 있습니다.";

    public static void validate(String number) {
        if (NumberValidator.isNegative(number)) {
            throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
        }
    }

    private static boolean isNegative(String number) {
        return number.startsWith(NEGATIVE_SIGN);
    }
}
