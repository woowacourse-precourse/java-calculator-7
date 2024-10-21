package calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherUtils {
    public Matcher createMatcher(Pattern pattern, String inputNumber) {
        return pattern.matcher(inputNumber);
    }

    public boolean isPatternMatched(Matcher matcher) {
        return matcher.find();
    }

    public int findCustomDelimiterPosition(Matcher matcher) {
        isPatternMatched(matcher);
        return matcher.start();
    }

}
