package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionValidator {
    private static final String REGEX_PREFIX = "^\\d+((?:";
    private static final String REGEX_SUFFIX = ")\\d+)*$";
    private static final String REGEX_NATURAL_NUMBER = "\\d+";
    private final String validatorRegex;
    private final Separators separators;
    private final Pattern pattern;

    public ExpressionValidator(Separators separators) {
        this.separators = separators;
        this.validatorRegex = generateRegex();
        this.pattern = Pattern.compile(validatorRegex);
    }

    private String generateRegex() {
        return REGEX_PREFIX + separators.toRegexAllowOneOfSeparator() + REGEX_SUFFIX;
    }

    public boolean isValidateExpression(String expression) {
        if (isNaturalNumber(expression) || expression.isEmpty()) {
            return true;
        }
        Matcher matcher = pattern.matcher(expression);
        return matcher.matches();
    }

    private boolean isNaturalNumber(String expression) {
        return expression.matches(REGEX_NATURAL_NUMBER);
    }
}
