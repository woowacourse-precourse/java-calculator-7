package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delimiters {
    private final String REGEX_EXPRESSION = ".^$*+?()[]{}|\\";
    private List<String> delimiters = new ArrayList<>();

    public Delimiters(CustomDelimiter customDelimiter) {
        delimiters.add(":");
        delimiters.add(",");

        if (customDelimiter.isValueExist()) {
            String value = getCustomDelimiterValue(customDelimiter.getValue());
            delimiters.add(value);
        }
    }

    public String convertToRegex() {
        return String.join("|", delimiters);
    }

    private String getCustomDelimiterValue(String value) {
        if (isValueHasRegexExpression(value)) {
            return "\\" + value;
        }

        return value;
    }

    private boolean isValueHasRegexExpression(String value) {
        String[] exps = REGEX_EXPRESSION.split("");
        return Arrays.stream(exps)
                .anyMatch(exp -> value.contains(exp));
    }
}
