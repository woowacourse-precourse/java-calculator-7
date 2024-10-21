package calculator.util;

import calculator.constant.MessageConst;
import java.math.BigInteger;

public class NumberValidationUtil {

    private static final String DEFAULT_SEPARATORS = ",:";

    /**
     * 커스텀 구분자와 숫자 문자열을 받아서 모든 검증을 한 번에 처리하는 메서드.
     *
     * @param numberString    숫자 문자열
     * @param customSeparator 커스텀 구분자
     */
    public static void validateNumberString(String numberString, String customSeparator) {
        validatePositiveNumbers(numberString, customSeparator);
        validateNumberStringFormat(numberString, customSeparator);
        validateNumberAfterSeparator(numberString, customSeparator);
    }

    /**
     * 숫자 문자열이 커스텀 구분자 및 기본 구분자 외에 다른 문자를 포함하지 않는지 검증.
     */
    private static void validateNumberStringFormat(String numberString, String customSeparator) {
        String validSeparators = DEFAULT_SEPARATORS + customSeparator;

        if (!numberString.matches("[" + validSeparators + "\\d]+")) {
            throw new IllegalArgumentException(MessageConst.INVALID_NUMBER_MSG);
        }
    }

    /**
     * 구분자 다음에 숫자가 나오는지 검증.
     */
    private static void validateNumberAfterSeparator(String numberString, String customSeparator) {
        String[] numbers = numberString.split("[" + DEFAULT_SEPARATORS + customSeparator + "]", -1);
        for (String number : numbers) {
            if (number.isEmpty()) {
                throw new IllegalArgumentException(MessageConst.INVALID_NUMBER_MSG);
            }
        }
    }

    /**
     * 숫자 문자열에 있는 모든 숫자가 양수인지 검증.
     */
    private static void validatePositiveNumbers(String numberString, String customSeparator) {
        String[] numbers = numberString.split("[" + DEFAULT_SEPARATORS + customSeparator + "]");
        for (String number : numbers) {
            BigInteger isPositiveNumber = new BigInteger(number);
            if (isPositiveNumber.compareTo(BigInteger.ZERO) <= 0) {
                throw new IllegalArgumentException(MessageConst.INVALID_NUMBER_MSG);
            }
        }
    }
}
