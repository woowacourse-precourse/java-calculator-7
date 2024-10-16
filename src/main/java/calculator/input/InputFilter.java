package calculator.input;

import calculator.utils.NumUtil;

public class InputFilter {

    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\\n";
    private static final int CUSTOM_LENGTH = 5;

    public static Input from(String input) {
        if (isCustom(input)) {
            return new CustomInput(getCleanedNums(input), getCustomSeparator(input));
        }
        return new Input(validateNums(input));
    }

    private static boolean isCustom(String input) {
        if (input.length() < CUSTOM_LENGTH) {
            return false;
        }
        return isCustomFormat(input);
    }

    private static boolean isCustomFormat(String input) {
        String customPrefix = input.substring(0, CUSTOM_PREFIX.length());
        String customSuffix = input.substring(CUSTOM_PREFIX.length() + 1, CUSTOM_LENGTH);
        return customPrefix.equals(CUSTOM_PREFIX) && customSuffix.equals(CUSTOM_SUFFIX);
    }

    private static String getCleanedNums(String input) {
        return validateNums(input.substring(CUSTOM_LENGTH));
    }

    private static String validateNums(String nums) {
        if (!NumUtil.isValidFirstNum(nums)) {
            throw new IllegalArgumentException("숫자 문자열이 숫자로 시작하지 않습니다.");
        }
        return nums;
    }

    private static char getCustomSeparator(String input) {
        return input.charAt(CUSTOM_PREFIX.length());
    }
}
