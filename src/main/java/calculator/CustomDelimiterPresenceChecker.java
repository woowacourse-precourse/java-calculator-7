package calculator;

import calculator.utils.MatcherUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.Constants.DELIMITER_PATTERN;


public class CustomDelimiterPresenceChecker {

    private final Pattern pattern = Pattern.compile(DELIMITER_PATTERN);

    private final MatcherUtils matcherUtils = new MatcherUtils();

    public boolean existsCustomDelimiter(String inputNumber) {
        Matcher matcher = matcherUtils.createMatcher(pattern, inputNumber);
        return matcherUtils.isPatternMatched(matcher);
    }

    public int getCustomDelimiterPos(String inputNumber) {
        Matcher matcher = matcherUtils.createMatcher(pattern, inputNumber);
        return matcherUtils.findCustomDelimiterPosition(matcher);
    }


}
