package calculator.model;

public class UserString {

    private final String[] splitValue;

    public UserString(String userInput) {

        String DELIMITERS = ",:";
        if (userInput.startsWith("//")) {
            int endIdx = userInput.indexOf("\\n");
            Validator.validateWrongCustom(endIdx);
            DELIMITERS += userInput.substring(2, endIdx);
            userInput = userInput.substring(endIdx + 2);
        }

        String[] split = userInput.split("[" + DELIMITERS + "]");
        Validator.validateWrongFormat(split);
        Validator.validatePositiveNumber(split);
        splitValue = split;
    }

    public int sum() {
        int sum = 0;
        for (String num : splitValue) {
            sum += Integer.parseInt(num);
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
                    Integer.parseInt(s);
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
                if (Integer.parseInt(s) <= 0) {
                    throw new IllegalArgumentException(NOT_POSITIVE_NUM_ERROR_MSG);
                }
            }
        }
    }

}
