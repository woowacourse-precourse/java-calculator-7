package calculator;

import java.util.List;

public class Validator {

    private static final String CUSTOM = "custom";
    private static final String PREFIX_CUSTOM_START = "//";
    private static final String PREFIX_CUSTOM_LAST = "\\n";
    private static final String WRONG_INPUT_MESSAGE = "잘못된 입력입니다.";
    private static final String WRONG_CUSTOM_SEPARATOR_FORM_MESSAGE = "custom 구분자의 형식이 잘못되었습니다.";
    private static final String IS_BEYOND_COMPUTE_MESSAGE = "계산할 수 없는 범위입니다.";

    public static void validate(String input, String type) {
        if (type.equals(CUSTOM)) {
            validateCustomSeparatorInput(input);
            return;
        }
        validateDefaultInput(input);
    }

    public static void validateDefaultInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) == ',' || input.charAt(i) == ':' || Character.isDigit(input.charAt(i)))) {
                throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
            }
        }
    }

    public static void validateCustomSeparatorInput(String input) {
        String separatorString = Parser.getSeparatorString(input);
        isCorrectPair(separatorString);
    }

    public static void isIntegerRangeSum(int sum, List<Integer> input) {
        long longSum = 0;
        for (Integer num : input) {
            longSum += num;
        }
        if (longSum != sum) {
            throw new IllegalArgumentException(IS_BEYOND_COMPUTE_MESSAGE);
        }
    }

    private static void isCorrectPair(String input) {
        boolean flag = false;
        for (int i = 0; i < input.length(); i++) {
            if (input.startsWith(PREFIX_CUSTOM_START, i)) {
                if (i + 4 >= input.length() || !isCorrectLastElement(input, i + 3)) {
                    throw new IllegalArgumentException(WRONG_CUSTOM_SEPARATOR_FORM_MESSAGE);
                }
                flag = true;
                i++;
            }
            if (input.startsWith(PREFIX_CUSTOM_LAST, i)) {
                if (!flag) {
                    throw new IllegalArgumentException(WRONG_CUSTOM_SEPARATOR_FORM_MESSAGE);
                }
                flag = false;
                i++;
            }
        }
        if (flag) {
            throw new IllegalArgumentException(WRONG_CUSTOM_SEPARATOR_FORM_MESSAGE);
        }
    }

    private static boolean isCorrectLastElement(String input, int idx) {
        if (input.startsWith(PREFIX_CUSTOM_LAST, idx)) {
            return true;
        }
        return false;
    }
}
