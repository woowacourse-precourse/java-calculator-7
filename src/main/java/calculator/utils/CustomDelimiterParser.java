package calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterParser {

    private static final Pattern pattern = Pattern.compile("//(.+)\\\\n");
    private static final String EMPTY = "";

    private CustomDelimiterParser() {
    }

    public static CustomDelimiterResult parse(final String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String group = matcher.group();
            String replace = input.replace(group, EMPTY);
            return new CustomDelimiterResult(matcher.group(1), replace);
        }
        return new CustomDelimiterResult(EMPTY, input);
    }

    public record CustomDelimiterResult(
            String delimiter,
            String expression
    ) {
    }
}
