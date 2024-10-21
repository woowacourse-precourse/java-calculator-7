package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String REGEX = "^(//([a-zA-Z!@#$%^&*?._=+\\-;~`|/\\\\])\\\\n)?(\\d+(?:(,|:|\\2)\\d+)*)?$|^\"\"$";

    public static boolean inputValidator(String input) {
        if (input.equals("\"\"")) { // 공백 문자열인 경우 true 반환
            return true;
        }
        Pattern inputPattern = Pattern.compile(REGEX);
        Matcher matcher = inputPattern.matcher(input);
        return matcher.find();
    }

    public static void validateMatcher(Matcher matcher) {
        if (!matcher.find()) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
    }
}



