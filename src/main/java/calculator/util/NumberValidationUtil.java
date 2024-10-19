package calculator.util;

import calculator.constant.MessageConst;

public class NumberValidationUtil {

    private static final String DEFAULT_SEPARATORS = ",:";

    /**
     * 커스텀 구분자와 숫자 문자열을 받아서 모든 검증을 한 번에 처리하는 메서드.
     *
     * @param numbers         숫자 문자열
     * @param customSeparator 커스텀 구분자
     */
    public static void validateNumbers(String numbers, String customSeparator) {
        validateNumberStringFormat(numbers, customSeparator);
        validateNumberAfterSeparator(numbers, customSeparator);
        validatePositiveNumbers(numbers, customSeparator);
    }

    /**
     * 숫자 문자열이 커스텀 구분자 및 기본 구분자 외에 다른 문자를 포함하지 않는지 검증.
     */
    private static void validateNumberStringFormat(String numbers, String customSeparator) {
        String validSeparators = DEFAULT_SEPARATORS + customSeparator;
        if (!numbers.matches("[" + validSeparators + "\\d]+")) {
            throw new IllegalArgumentException(MessageConst.INVALID_NUMBER_MSG);
        }
    }

    /**
     * 구분자 다음에 숫자가 나오는지 검증.
     */
    private static void validateNumberAfterSeparator(String numbers, String customSeparator) {
        String[] tokens = numbers.split("[" + DEFAULT_SEPARATORS + customSeparator + "]", -1);
        for (String token : tokens) {
            if (token.isEmpty()) {
                throw new IllegalArgumentException(MessageConst.INVALID_NUMBER_MSG);
            }
        }
    }

    /**
     * 숫자 문자열에 있는 모든 숫자가 양수인지 검증.
     */
    private static void validatePositiveNumbers(String numbers, String customSeparator) {
        String[] tokens = numbers.split("[" + DEFAULT_SEPARATORS + customSeparator + "]");
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number <= 0) {
                throw new IllegalArgumentException(MessageConst.INVALID_NUMBER_MSG);
            }
        }
    }
}
