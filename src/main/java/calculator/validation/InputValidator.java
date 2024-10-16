package calculator.validation;

import calculator.enums.ErrorMessage;

public class InputValidator {

    private static final String CUSTOM_FIRST_DELIMITER = "//";
    private static final String CUSTOM_SECOND_DELIMITER = "\n";

    public InputValidator() {
    }

    public static void validateStartBlank(String input) {
        if (input != null && input.startsWith(" ")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_BLANK.getMessage());
        }
    }

    /**
     * 커스텀 구분자 형식에서 '\n'이 없을 경우 예외를 발생
     */
    public static void validateCustomSecond(String input) {
        if (input.startsWith(CUSTOM_FIRST_DELIMITER)) {
            if (!input.contains(CUSTOM_SECOND_DELIMITER)) {
                throw new IllegalArgumentException(ErrorMessage.SECOND_SEPARATOR_MISS.getMessage());
            }
        }
    }

    /**
     * 커스텀 구분자 형식에서 구분자가 2개 이상일 경우 예외를 발생
     */
    public static void validateCustomLength(String input) {
        if (input.startsWith(CUSTOM_FIRST_DELIMITER)) {
            int delimiterEndIndex = input.indexOf(CUSTOM_SECOND_DELIMITER);
            String customDelimiter = input.substring(2, delimiterEndIndex);

            if (customDelimiter.length() > 1) {
                throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_SEPARATOR_OVER_TWO.getMessage());
            }
        }
    }
}
