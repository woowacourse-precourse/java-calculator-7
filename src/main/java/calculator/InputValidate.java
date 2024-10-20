package calculator;

import java.util.regex.Pattern;

public class InputValidate {

    private static String delimiter;
    private static final String customStart = "//";
    private static final String NOT_CUSTOM = "입력 값이 올바르지 않습니다.";
    private static final String NOT_CUSTOM_BE_DIGIT = "구분자가 숫자가 될 수 없습니다.";

    public static String checkCustom(String userInput) {
        delimiter = ",|:";
        if (userInput.startsWith(customStart)) {
            if (userInput.indexOf("\\n") != 3) {
                throw new IllegalArgumentException(NOT_CUSTOM);
            }
            customValidateCheck(userInput.charAt(2));
        }
        return delimiter;
    }

    public static void customValidateCheck(char customVal) {
        if (Character.isDigit(customVal)) {
            throw new IllegalArgumentException(NOT_CUSTOM_BE_DIGIT);
        }
        addDelimiter(customVal);
    }

    public static void addDelimiter(char addOneDelimiter) {
        delimiter += "|" + Pattern.quote(String.valueOf(addOneDelimiter));
    }
}