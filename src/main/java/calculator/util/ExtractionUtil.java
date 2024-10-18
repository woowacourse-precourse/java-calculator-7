package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractionUtil {
    private static final String CUSTOM_DELIMITER_REGEX =
            "^//" // "//"로 시작
                    + "((?:(?!\\\\n)\\D)*)" // group1 : 문자열 "\n"이 없고, 숫자가 아닌 문자의 0개 이상 반복
                    + "((?:\\\\n)?)" // group2 : 문자열 "\n"이 0개 또는 1개
                    + "((?:(?!\\\\n)\\D)*)" // group 3 : 다시 group1과 같은 표현
                    + "\\\\n" // 커스텀 구분자 입력 종료를 의미하는 문자열 "\n"
                    + "([\\s\\S]*)$"; // group 4 : 남아있는 공백을 포함하는 모든 문자

    public static char[] extractDelimiter(String text) {
        String[] parts = splitInput(text);
        return parts[0].toCharArray();
    }

    public static String extractExpression(String text) {
        String[] parts = splitInput(text);
        return parts[1];
    }

    public static String[] splitInput(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            String delimiterStr = matcher.group(1) + matcher.group(2) + matcher.group(3);
            String expression = matcher.group(4);
            return new String[]{delimiterStr, expression};
        }
        return new String[]{"", input};
    }
}
