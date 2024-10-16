package calculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser implements Parser{

    private static final String CUSTOM_DELIMITER = "//([^0-9]+)\\\\n";

    private String notValidDelimiter = "[^:,.0-9]";
    private String delimiter = "[:,]";
    private String expression;

    public StringParser(String expression) {
        this.expression = expression;
        setCustomDelimiter();
    }

    private void setCustomDelimiter() {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(expression);
        if (matcher.find() && expression.startsWith(matcher.group())) {
            this.expression = expression.replace(matcher.group(), "");
            this.delimiter = delimiter.replace(":,", matcher.group(1));
            notValidDelimiter = notValidDelimiter.replace(":,", matcher.group(1));
        }
    }

    @Override
    public List<Double> parse() {
        if (expression.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.stream(splitExpression())
                .filter(token -> !token.isEmpty())
                .map(this::stringToDouble)
                .toList();
    }

    private String[] splitExpression() {
        if (hasWrongGrammar()) {
            throw new IllegalArgumentException(String.format("%s : 기본 문법에 어긋나는 표현식입니다.", expression));
        }
        return expression.split(delimiter);
    }

    private boolean hasWrongGrammar() {
        return Pattern.compile(notValidDelimiter)
                .matcher(expression)
                .find();
    }

    private Double stringToDouble(String token) {
        try {
            return Double.parseDouble(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s : 실수형으로 변환할 수 없는 문자열입니다.", token));
        }
    }
}
