package calculator.utils;

public class Validator {
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자이여야 합니다.";
    private static final String POSITIVE_NUMBER_EXCEPTION_MESSAGE = "양수이여야 합니다.";
    private static final String CUSTOM_SEPARATOR_EXCEPTION_MESSAGE = "커스텀 구분자는 한 글자여야 합니다.";

    public static void isNumber(String[] tokens) {
        for (String token : tokens) {
            try {
                Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
            }
        }
    }

    public static void isPositiveNumber(String[] tokens) {
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number <= 0) {
                throw new IllegalArgumentException(POSITIVE_NUMBER_EXCEPTION_MESSAGE);
            }
        }
    }

    public static void validateSingleCharacterSeparator(String separator) {
        if (separator == null || separator.length() != 1) {
            throw new IllegalArgumentException(CUSTOM_SEPARATOR_EXCEPTION_MESSAGE);
        }
    }
}
