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
     * 입력된 문자열에서 숫자 자리에 양의 정수 이외의 문자가 포함된 경우 예외 발생
     */
    public static void validateNumberOnly(String input) {
        String[] delimiters = splitCustomInput(input);

        for (String delimiter : delimiters) {
            delimiter = delimiter.trim();

            validateIsNumber(delimiter);
            validateNumberNegative(delimiter);
        }
    }

    private static String[] splitCustomInput(String input) {
        // 커스텀 구분자를 사용하는 경우
        if (input.startsWith(CUSTOM_FIRST_DELIMITER)) {
            int delimiterEndIndex = input.indexOf(CUSTOM_SECOND_DELIMITER);

            String customDelimiter = input.substring(2, delimiterEndIndex);
            String numbers = input.substring(delimiterEndIndex + 1);

            return numbers.split(customDelimiter + "|" + DEFAULT_DELIMITERS);
        } else {
            return input.split(DEFAULT_DELIMITERS);  // 기본 구분자를 사용하는 경우
        }
    }

    /**
     * 입력된 문자열에서 숫자 자리에 음수가 포함된 경우 예외 발생
     */
    private static void validateNumberNegative(String delimiter) {
        // 음수 확인
        if (Integer.parseInt(delimiter) < 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_NEGATIVE.getMessage());
        }
    }

    /**
     * 입력된 문자열에서 숫자 자리에 정수 이외의 문자가 포함된 경우 예외 발생
     */
    private static void validateIsNumber(String delimiter) {
        if (!isNumber(delimiter)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getMessage());
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

    /**
     * 기본 구분자와 커스텀 구분자 외의 구분자가 포함된 경우 예외 발생
     */
    public static void validateInvalidDelimiter(String input) {
        String[] numbers = splitCustomInput(input);

        for (String number : numbers) {
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException(ErrorMessage.NOT_DEFINE_CUSTOM_SEPARATOR.getMessage());
            }
        }
    }

    /**
     * 입력된 문자열에 숫자 0이 포함된 경우 예외 발생
     */
    public static void validateZero(String input) {
        String[] numbers = splitCustomInput(input);

        for (String number : numbers) {
            number = number.trim();

            if (number.matches("0+")) {
                throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_ONLY_ZERO.getMessage());
            }
        }
    }

    /**
     * 기본 구분자와 커스텀 구분자가 연속으로 사용된 경우 예외 발생
     */
    public static void validateMixedDelimiters(String input) {
        String[] numbers = splitCustomInput(input);

        for (int i = 0; i < numbers.length - 1; i++) {
            // 연속된 숫자가 구분자인지 확인(숫자가 아닌 경우 예외 발생)
            if (numbers[i].isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_DUPLICATION_SEPARATOR.getMessage());
            }
        }
    }
}
