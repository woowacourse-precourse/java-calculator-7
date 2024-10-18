package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterValidation {

    private static final String DEFAULT_DELIMITER_REGEX = "^(|([1-9][0-9]*([,:][1-9][0-9]*)*))$";
    private static final String CUSTOM_DELIMITER_REGEX = "^//([^0-9])\\\\n(|([1-9][0-9]*(\\1[1-9][0-9]*)*))$";

    // regexMatcher 반환 함수
    private static Matcher regexMatcher(String formula, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(formula);
    }

    // 기본 구분자 검증 함수
    private static String[] validateDefaultDelimiter(String formula) {
        Matcher matcher = regexMatcher(formula, DEFAULT_DELIMITER_REGEX);
        if (matcher.matches()) {
            return new String[]{"[,:]", matcher.group(1)};
        }
        throw new IllegalArgumentException("잘못된 사용자 입력입니다.");
    }

    // 커스텀 구분자 검증 함수
    private static String[] validateCustomDelimiter(String formula) {
        Matcher matcher = regexMatcher(formula, CUSTOM_DELIMITER_REGEX);
        if (matcher.matches()) {
            return new String[]{Pattern.quote(matcher.group(1)), matcher.group(2)};
        }
        throw new IllegalArgumentException("잘못된 사용자 입력입니다.");
    }

    static String[] validateDelimiter(boolean isCustomDelimiter, String formula) {
        if (isCustomDelimiter) {
            return validateCustomDelimiter(formula);
        }
        return validateDefaultDelimiter(formula);
    }

}
