package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//  입력 문자열의 구분자를 처리
public class DelimiterUtils {

    // 커스텀 구분자를 처리하는 패턴. "\n" 처리를 위한 정규식 수정
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    // 유틸리티 클래스이므로 인스턴스 생성 방지
    private DelimiterUtils() {
    }

    // 커스텀 구분자 패턴을 반환
    public static Pattern getCustomDelimiterPattern() {
        return CUSTOM_DELIMITER_PATTERN;
    }

    // 기본 구분자(쉼표, 콜론)를 위한 정규식 반환
    public static String getDefaultDelimiterRegex() {
        return "[,:]";
    }

    // 입력을 커스텀 또는 기본 구분자로 나누어 배열로 반환
    public static String[] splitByDelimiter(String input) {
        Matcher matcher = getCustomDelimiterMatcher(input);

        if (matcher.matches()) {
            return splitByCustomDelimiter(matcher);
        }
        return splitByDefaultDelimiter(input);
    }

    // 커스텀 구분자를 사용하여 문자열 분리
    private static String[] splitByCustomDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(1);  // 단일 커스텀 구분자
        return matcher.group(2).split(Pattern.quote(customDelimiter));
    }

    // 기본 구분자(쉼표, 콜론)를 사용하여 문자열 분리
    private static String[] splitByDefaultDelimiter(String input) {
        return input.split(getDefaultDelimiterRegex());
    }

    // 입력에서 커스텀 구분자를 찾는 매처 생성
    private static Matcher getCustomDelimiterMatcher(String input) {
        return getCustomDelimiterPattern().matcher(input);
    }
}