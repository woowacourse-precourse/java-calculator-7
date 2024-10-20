package calculator;

import java.util.regex.Pattern;

public class CustomDelimiterExtractor {

    private static final Pattern DIGIT_PATTERN = Pattern.compile("\\d");
    private static final String EMPTY = "";

    private final String prefix;
    private final String suffix;

    public CustomDelimiterExtractor(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public DelimiterResult extractDelimiter(String expression) {
        if (!expression.startsWith(prefix)) {
            return new DelimiterResult(false, EMPTY, expression);
        }
        if (!expression.contains(suffix)) {
            throw new IllegalArgumentException("커스텀 구분자는 %s와 %s로 감싸져 있어야 합니다.".formatted(prefix, suffix));
        }
        String delimiter = expression.substring(prefix.length(), expression.indexOf(suffix));
        String remainingExpression = expression.substring(expression.indexOf(suffix) + suffix.length());
        validateNonDigit(delimiter);
        return new DelimiterResult(true, delimiter, remainingExpression);
    }

    private void validateNonDigit(String delimiter) {
        if (DIGIT_PATTERN.matcher(delimiter).matches()) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자일 수 없습니다.");
        }
    }
}
