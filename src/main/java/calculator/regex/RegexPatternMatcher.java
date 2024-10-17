package calculator.regex;

import java.util.regex.Pattern;

public class RegexPatternMatcher {
    private final Pattern pattern;

    public RegexPatternMatcher(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public int countMatches(String input) {
        var matcher = pattern.matcher(input);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public String getMatch(String input) {
        var matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
