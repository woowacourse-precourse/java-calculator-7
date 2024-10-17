package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterUtils {

    // 커스텀 구분자를 처리하는 패턴. "\\n" 처리를 위한 정규식 적용
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    // 유틸리티 클래스이므로 인스턴스 생성 방지
    private DelimiterUtils() {
    }

    public static Pattern getCustomDelimiterPattern() {
        return CUSTOM_DELIMITER_PATTERN;
    }

    public static String getDefaultDelimiterRegex() {
        return "[,:]";
    }

    public static String[] splitInput(String input) {
        Matcher matcher = getCustomDelimiterMatcher(input);

        if (matcher.matches()) {
            return splitByCustomDelimiter(matcher);
        }
        return splitByDefaultDelimiter(input);
    }

    private static String[] splitByCustomDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(1);  // 단일 커스텀 구분자
        return matcher.group(2).split(Pattern.quote(customDelimiter));
    }

    private static String[] splitByDefaultDelimiter(String input) {
        return input.split(getDefaultDelimiterRegex());
    }

    private static Matcher getCustomDelimiterMatcher(String input) {
        return getCustomDelimiterPattern().matcher(input);
    }
}