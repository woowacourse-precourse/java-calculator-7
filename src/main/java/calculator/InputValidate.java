package calculator;

import java.util.regex.Pattern;

public class InputValidate {
    private static String delimiter = ",|:";
    private static final String customStart = "//";

    public static String checkCustom(String UserInput) {
        if (UserInput.startsWith(customStart)) {
            if (UserInput.indexOf("\\n", 2) != 3) {
                throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
            }
            customValidateCheck(UserInput.charAt(2));
        }
        return delimiter;
    }

    public static void customValidateCheck(char CustomVal) {
        if (Character.isDigit(CustomVal)) {
            throw new IllegalArgumentException("구분자가 숫자가 될 수 없습니다.");
        }
        addDelimiter(CustomVal);
    }

    public static void addDelimiter(char addOneDelimiter) {
        delimiter += "|" + Pattern.quote(String.valueOf(addOneDelimiter));
    }
}