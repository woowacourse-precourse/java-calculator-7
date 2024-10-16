package calculator.validation;

import calculator.enums.ErrorMessage;

public class InputValidator {

    private static final String CUSTOM_FIRST_DELIMITER = "//";
    private static final String CUSTOM_SECOND_DELIMITER = "\n";

    private static final String DEFAULT_DELIMITERS = ",|:";

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

    /**
     * 입력된 문자열에서 숫자 자리에 숫자 이외의 문자가 포함된 경우 예외 발생
     */
    public static void validateNumberOnly(String input) {
        String[] delimiters;

        // 커스텀 구분자를 사용하는 경우
        if (input.startsWith(CUSTOM_FIRST_DELIMITER)) {
            int delimiterEndIndex = input.indexOf(CUSTOM_SECOND_DELIMITER);

            String customDelimiter = input.substring(2, delimiterEndIndex);
            String numbers = input.substring(delimiterEndIndex + 1);

            delimiters = numbers.split(customDelimiter);
        } else {
            delimiters = input.split(DEFAULT_DELIMITERS);  // 기본 구분자를 사용하는 경우
        }
        for (String delimiter : delimiters) {
            delimiter = delimiter.trim();

            // 숫자인지 확인
            if (!isNumber(delimiter)) {
                throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getMessage());
            }

            // 음수 확인
            if (Integer.parseInt(delimiter) < 0) {
                throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_NEGATIVE.getMessage());
            }
        }
    }

    private static boolean isNumber(String delimiter) {
        try {
            Integer.parseInt(delimiter);  // 정수로 변환
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
