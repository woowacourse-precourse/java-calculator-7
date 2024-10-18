package calculator.pattern;

import java.util.regex.Pattern;

public class RegexPatternMatcher implements PatternMatcher {
    private final Pattern pattern;

    public RegexPatternMatcher(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public String getMatch(String input) {
        var matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    @Override
    public int countMatches(String input) {
        var matcher = pattern.matcher(input);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
