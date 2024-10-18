package calculator.model;

import static calculator.constants.Symbol.ASTERISK;
import static calculator.constants.Symbol.CUSTOM_DELIMITER_PREFIX;
import static calculator.constants.Symbol.CUSTOM_DELIMITER_SUFFIX;
import static calculator.constants.Symbol.END_BRACKET;
import static calculator.constants.Symbol.PREFIX_OFFSET;
import static calculator.constants.Symbol.START_BRACKET;

import java.util.regex.Pattern;

public class Expression {
    private final String NUMBER_REGEX = "1-9";
    private final String ERROR_MESSAGE = "유효하지 않은 문자가 포함되어 있습니다.";
    private final Separator separator;
    private final Terms terms;

    public Expression(String expression) {
        this.separator = new Separator(parseFormularExpression(expression));
        validateExpression(expression);
        this.terms = new Terms(parseFormularExpression(expression), separator);
    }

    private void validateExpression(String expression) {
        expression = parseFormularExpression(expression);
        if (hasInvalidinput(expression)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private boolean hasInvalidinput(String expression) {
        String totalSeparator = separator.getSeparator();
        String regex = START_BRACKET + NUMBER_REGEX + Pattern.quote(totalSeparator) + END_BRACKET + ASTERISK;
        return !expression.matches(regex);
    }

    private boolean hasCustomSeparator(String expression) {
        return expression.startsWith(CUSTOM_DELIMITER_PREFIX) && expression.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    private String parseFormularExpression(String expression) {
        if (hasCustomSeparator(expression)) {
            return extractCustomExpression(expression);
        }
        return expression;
    }

    private String extractCustomExpression(String expression) {
        int start = expression.indexOf(CUSTOM_DELIMITER_SUFFIX) + PREFIX_OFFSET;
        return expression.substring(start);
    }

    public Terms getTerms() {
        return terms;
    }
}
