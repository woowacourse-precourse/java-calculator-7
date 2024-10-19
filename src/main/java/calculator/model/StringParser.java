package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private static final String INITIAL_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final String CUSTOM_DELIMITER_REGEX = "//([^0-9])\\\\n";
    private static final String[] SPECIAL_CHARACTER = {"\\", "^", "$", ".", "|", "?", "*", "+", "(", ")", "{", "}", "[", "]"};
    private static final String ESCAPE_STRING = "\\";

    public String extractCustomDelimiter(String input) {    //  문자열에서 커스텀 구분자를 추출하는 메서드
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            if (isSpecialChar(customDelimiter)) {
                return ESCAPE_STRING + customDelimiter;
            }
            return customDelimiter;
        } else {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    public boolean isSpecialChar(String customDelimiter) {  //  escape 처리가 필요한 특수 문자인지 확인하는 메서드
        return Arrays.asList(SPECIAL_CHARACTER).contains(customDelimiter);
    }

    public boolean isCustomDelimiterUsed(String input) {    //  입력된 문자열에서 커스텀 구분자를 지정하는지 확인하는 메서드
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return input.contains(CUSTOM_DELIMITER_SUFFIX);
        }
        return false;
    }

    public String[] separateElements(String input) {    //  입력된 문자열에서 구분자를 기준으로 분리하는 메서드
        String delimiters = INITIAL_DELIMITER;
        if (isCustomDelimiterUsed(input)) {
            String customDelimiterSubstring = input.substring(0, input.indexOf(CUSTOM_DELIMITER_SUFFIX) + 2);
            String customDelimiter = extractCustomDelimiter(customDelimiterSubstring);
            delimiters += "|" + customDelimiter;
            System.out.println("delimiters : " + delimiters);
        }
        String expression = input.substring(input.indexOf(CUSTOM_DELIMITER_SUFFIX) + 2);
        return expression.split(delimiters);
    }
}