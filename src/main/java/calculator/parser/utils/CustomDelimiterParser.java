package calculator.parser.utils;

import calculator.regex.RegexPatternMatcher;

public class CustomDelimiterParser {
    private final RegexPatternMatcher customDelimiterMatcher;

    public CustomDelimiterParser(String prefix, String suffix) {
        prefix = prefix.replace("\\", "\\\\");
        suffix = suffix.replace("\\", "\\\\");
        String regex = String.format("%s(.*?)%s", prefix, suffix);
        this.customDelimiterMatcher = new RegexPatternMatcher(regex);
    }

    public Character getDelimiter(String input) {
        int countMatches = customDelimiterMatcher.countMatches(input);
        if (countMatches == 0) {
            return null;
        }

        if (1 < countMatches) {
            throw new IllegalArgumentException("Delimiter는 하나 뿐이어야 합니다.");
        }

        String match = customDelimiterMatcher.getMatch(input);
        if (1 < match.length()) {
            throw new IllegalArgumentException("Delimiter must be a single character");
        } else if (match.isEmpty()) {
            throw new IllegalArgumentException("Delimiter의 길이는 1이어야 합니다.");
        } else if (Character.isDigit(match.charAt(0))) {
            throw new IllegalArgumentException("Delimiter는 숫자가 될 수 없습니다.");
        }

        return match.charAt(0);
    }

}
