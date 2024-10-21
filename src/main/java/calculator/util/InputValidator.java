package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public static void validate(String input) {
        hasWhiteSpace(input);
        validStartWord(input);
        validEndWord(input);
        validDelimiters(input);
    }

    private static void hasWhiteSpace(String input) {
        if (input.contains(" ")) {
           throw new IllegalArgumentException("입력 문자열은 공백을 포함할 수 없습니다.");
        }
    }

    private static void validStartWord(String input) {
        if (input.startsWith(",") || input.startsWith(":")) {
           throw new IllegalArgumentException("입력 문자열은 구분자로 시작할 수 없습니다.");
        }
    }

    private static void validEndWord(String input) {
        if (input.endsWith(",") || input.endsWith(":")) {
           throw new IllegalArgumentException("입력 문자열은 구분자로 끝날 수 없습니다.");
        }
    }

    private static void validDelimiters(String input) {
        String delimiter1 = ",|:";
        Pattern pattern1 = Pattern.compile(delimiter1);
        Matcher matcher1 = pattern1.matcher(input);

        String delimiter2 = "//(.*)\\n(.*)";
        Pattern pattern2 = Pattern.compile(delimiter2);
        Matcher matcher2 = pattern2.matcher(input);

        if (!matcher1.find() && !matcher2.find()) {
            throw new IllegalArgumentException("입력 문자열이 유효한 구분자를 포함하지 않습니다.");
        }
    }
}
