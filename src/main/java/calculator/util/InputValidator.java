package calculator.util;

public class InputValidator {

    private static final String ILLEGAL_ARGUMENT_EXCEPTION = "잘못된 입력: 구분자 또는 숫자 외의 문자가 포함되어 있습니다.";
    private static final String POSITIVE_NUMBERS_REQUIRED = "잘못된 입력: 숫자는 양수만 허용됩니다.";

    public int validateStringToken(String stringToken) {

        int parsedInt = checkNonDelimiter(stringToken);
        checkPositive(parsedInt);

        return parsedInt;
    }

    private int checkNonDelimiter(String stringToken) {
        try {
            return Integer.parseInt(stringToken);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION);
        }
    }

    private void checkPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(POSITIVE_NUMBERS_REQUIRED);
        }
    }
}
