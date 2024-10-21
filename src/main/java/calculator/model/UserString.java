package calculator.model;

import java.math.BigInteger;
import java.util.Arrays;

public class UserString {

    public static final String CUSTOM_PREFIX = "//";
    public static final String CUSTOM_SUFFIX = "\\n";
    public static final String PREFIX = "\\";
    public static final String DELIMITER_PREFIX = "[";
    public static final String DELIMITER_SUFFIX = "]";

    private final String[] splitValue;
    private final StringBuilder DELIMITERS = new StringBuilder(",:");
    
    public UserString(String userInput) {

        if (userInput.startsWith(CUSTOM_PREFIX)) {
            int endIdx = userInput.indexOf(CUSTOM_SUFFIX);
            Validator.validateWrongCustom(endIdx);
            String delimiter = userInput.substring(2, endIdx);
            if (delimiter.equals("[") || delimiter.equals("]") || delimiter.equals("\\")) {
                delimiter = PREFIX + delimiter;
            }
            DELIMITERS.append(delimiter);
            userInput = userInput.substring(endIdx + 2);
        }

        String[] split = userInput.split(DELIMITER_PREFIX + DELIMITERS + DELIMITER_SUFFIX);
        split = getSplitByStrip(split);
        Validator.validateWrongFormat(split);
        Validator.validatePositiveNumber(split);
        splitValue = split;
    }

    private static String[] getSplitByStrip(String[] split) {
        split = Arrays.stream(split)
                .map(String::strip)
                .toArray(String[]::new);
        return split;
    }

    public BigInteger sum() {
        BigInteger sum = BigInteger.ZERO;
        for (String num : splitValue) {
            sum = sum.add(new BigInteger(num));
        }

        return sum;
    }

    static class Validator {

        public static final String WRONG_FORMAT_ERROR_MSG = "[ERROR] 잘못된 형식의 문자열입니다.";
        public static final String WRONG_CUSTOM_ERROR_MSG = "[ERROR] 커스텀 구분자를 정확히 입력 해주세요.";
        public static final String NOT_POSITIVE_NUM_ERROR_MSG = "[ERROR] 숫자는 양수만 가능합니다.";

        public static void validateWrongFormat(String[] split) {
            // 구분자 사이 숫자가 아닌 입력의 예외처리
            // 커스텀구분자, 기본구분자에 포함 안되는 구분자 사용
            for (String s : split) {
                try {
                    new BigInteger(s);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(WRONG_FORMAT_ERROR_MSG);
                }
            }
        }

        public static void validateWrongCustom(int endIdx) {
            if (endIdx == -1 || endIdx - 2 > 1) {
                throw new IllegalArgumentException(WRONG_CUSTOM_ERROR_MSG);
            }
        }

        public static void validatePositiveNumber(String[] split) {
            for (String s : split) {
                if (BigInteger.ZERO.compareTo(new BigInteger(s)) >= 0) {
                    throw new IllegalArgumentException(NOT_POSITIVE_NUM_ERROR_MSG);
                }
            }
        }
    }

}
