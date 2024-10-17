package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomRegexMatcher {
    // ex) 커스텀 구분자를 ;로 정했을 때, //;\n1;2;3
    private static final String CUSTOM_REGEX = "//(.)\\\\n(.*)";

    public static Matcher getMatcher(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_REGEX);
        return pattern.matcher(input);
    }
}
