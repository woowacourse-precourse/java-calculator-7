package calculator.model;

import static calculator.constants.Symbol.ASTERISK;
import static calculator.constants.Symbol.CUSTOM_DELIMITER_PREFIX;
import static calculator.constants.Symbol.CUSTOM_DELIMITER_SUFFIX;
import static calculator.constants.Symbol.END_BRACKET;
import static calculator.constants.Symbol.PREFIX_OFFSET;
import static calculator.constants.Symbol.START_BRACKET;

import java.util.List;
import java.util.regex.Pattern;

public class Expression {
    private final String NUMBER_REGEX = "1-9";
    private final String ERROR_MESSAGE = "유효하지 않은 문자가 포함되어 있습니다.";
    private final String expression;
    private final Separator separator;
    private final Terms terms;

    public Expression(String expression) {
        this.separator = new Separator(expression);
        this.expression = validateExpression(extractformularExpression(expression));
        this.terms = new Terms(this.expression, this.separator);
    }

    public String extractformularExpression(String expression) {
        if (hasCustomSeparator(expression)) {
            return extractActualExpression(expression);
        }
        return expression;
    }

    private String validateExpression(String expression) {
        if (hasInvalidinput(expression)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return expression;
    }

    private boolean hasInvalidinput(String expression) {
        String totalSeparator = separator.getSeparator();
        String regex = START_BRACKET + NUMBER_REGEX + Pattern.quote(totalSeparator) + END_BRACKET + ASTERISK;
        return !expression.matches(regex);
    }

    private boolean hasCustomSeparator(String expression) {
        return expression.startsWith(CUSTOM_DELIMITER_PREFIX) && expression.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    private String extractActualExpression(String expression) {
        int start = expression.indexOf(CUSTOM_DELIMITER_SUFFIX) + PREFIX_OFFSET;
        return expression.substring(start);
    }

    public List<Term> getTerms() {
        return terms.getTerms();
    }
}
