package calculator.input;

import calculator.utils.NumUtil;

public class InputFilter {

    private static final String CUSTOM_REGEX = "^//.\\\\n.*";
    private static final int CUSTOM_PREFIX_LENGTH = 2;
    private static final int CUSTOM_LENGTH = 5;

    public static Input parseInput(String value) {
        if (isCustom(value)) {
            return new CustomInput(getCleanedNumStr(value), getCustomSeparator(value));
        }
        return new Input(validateNumStr(value));
    }

    private static boolean isCustom(String value) {
        return value.matches(CUSTOM_REGEX);
    }

    private static String getCleanedNumStr(String value) {
        return validateNumStr(value.substring(CUSTOM_LENGTH));
    }

    private static String validateNumStr(String numStr) {
        if (!NumUtil.isValidFirstNum(numStr)) {
            throw new IllegalArgumentException("숫자 문자열이 숫자로 시작하지 않습니다.");
        }
        return numStr;
    }

    private static char getCustomSeparator(String value) {
        return value.charAt(CUSTOM_PREFIX_LENGTH);
    }
}
