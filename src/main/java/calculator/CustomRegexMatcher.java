package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 주석이 다른 변수들과 섞여있을 시,
 * 변경의 위험성이 있을 수 있으므로
 * 단일의 클래스로 분리함.
 */
public class CustomRegexMatcher {
    // ex) 커스텀 구분자를 ;로 정했을 때, //;\n1;2;3
    private static final String CUSTOM_REGEX = "//(.)\\\\n(.*)";

    public static Matcher getMatcher(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_REGEX);
        return pattern.matcher(input);
    }
}
