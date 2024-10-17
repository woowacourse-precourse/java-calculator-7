package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterUtils {


    public static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    // 유틸리티 클래스이므로 인스턴스 생성 방지
    private DelimiterUtils() {
    }

    public static Pattern getCustomDelimiterPattern() {
        return CUSTOM_DELIMITER_PATTERN;
    }

    public static String getDefaultDelimiterRegex() {
        return DEFAULT_DELIMITER_REGEX;
    }

    // 입력 문자열을 구분자로 나누어 숫자 배열을 반환하는 메서드
    public static String[] splitInput(String input) {
        Matcher matcher = getCustomDelimiterMatcher(input);
        if (matcher.matches()) {
            return splitByCustomDelimiter(matcher);
        }
        return splitByDefaultDelimiter(input);
    }

    // 커스텀 구분자를 처리하는 메서드
    private static String[] splitByCustomDelimiter(Matcher matcher) {
        String customDelimiter = Pattern.quote(matcher.group(1));
        return matcher.group(2).split(customDelimiter);
    }

    // 기본 구분자를 처리하는 메서드
    private static String[] splitByDefaultDelimiter(String input) {
        return input.split(getDefaultDelimiterRegex());
    }

    // 입력 문자열에서 커스텀 구분자 패턴을 매칭하는 메서드
    private static Matcher getCustomDelimiterMatcher(String input) {
        return getCustomDelimiterPattern().matcher(input);
    }

}
