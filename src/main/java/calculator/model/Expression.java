package calculator.model;

import java.util.List;
import java.util.regex.Pattern;

public class Expression {
    private final String NUMBER_REGEX = "1-9";
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
            throw new IllegalArgumentException("유효하지 않은 문자가 포함되어 있습니다.");
        }
        return expression;
    }

    private boolean hasInvalidinput(String expression) {
        String totalSeparator = separator.getSeparator();
        String regex = "[" + NUMBER_REGEX + Pattern.quote(totalSeparator) + "]*";
        return !expression.matches(regex);
    }

    private boolean hasCustomSeparator(String expression) {
        return expression.startsWith("//") && expression.contains("\\n");
    }

    private String extractActualExpression(String expression) {
        int start = expression.indexOf("\\n") + 2;
        return expression.substring(start);
    }

    public List<Term> getTerms() {
        return terms.getTerms();
    }
}
