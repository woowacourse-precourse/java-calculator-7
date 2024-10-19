package calculator;

import java.util.regex.Pattern;

public class InputValidate {
    private static String delimiter = ",|:";
    private static final String customStart = "//";

    public static String checkCustom(String userInput) {
        if (userInput.startsWith(customStart)) {
            if (userInput.indexOf("\\n", 2) != 3) { // 2번째 인자는 없어도 좋을듯
                throw new IllegalArgumentException("입력 값이 올바르지 않습니다."); // 예외 메시지 구체적이면 좋을 듯
            }
            customValidateCheck(userInput.charAt(2));
        }
        return delimiter;
    }

    public static void customValidateCheck(char customVal) {
        if (Character.isDigit(customVal)) {
            throw new IllegalArgumentException("구분자가 숫자가 될 수 없습니다.");
        }
        addDelimiter(customVal);
    }

    public static void addDelimiter(char addOneDelimiter) {
        delimiter += "|" + Pattern.quote(String.valueOf(addOneDelimiter));
    }
}