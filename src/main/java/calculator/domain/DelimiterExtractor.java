package calculator.domain;

import static calculator.util.Constants.CUSTOM_DELIMITER_PATTERN;
import static calculator.util.Constants.DEFAULT_DELIMITERS;
import static calculator.util.Constants.DELIMITER_START_PATTERN;

import calculator.util.DelimiterValidator;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {

    private static final int FIRST = 1;
    private final Set<String> delimiters;
    private String expression;

    public DelimiterExtractor() {
        this.delimiters = new HashSet<>(DEFAULT_DELIMITERS);
    }

    public String getExpression() {
        return expression;
    }

    public String generateDelimiterRegex(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        while (matcher.find()) {
            String delimiter = matcher.group(FIRST);
            validateDelimiter(input, delimiter, matcher);

            if (!input.startsWith(DELIMITER_START_PATTERN)) {
                break;
            }

            delimiters.add(Pattern.quote(delimiter));
            input = input.substring(matcher.end());
            matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        }

        expression = input;
        return String.join("|", delimiters);
    }

    private void validateDelimiter(String input, String delimiter, Matcher matcher) {
        new DelimiterValidator(input, delimiter, matcher);
    }
}
