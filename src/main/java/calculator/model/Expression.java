package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private final String NUMBER_REGEX = "1-9";
    private final String expression;
    private final Separator separator;
    private final List<Term> terms = new ArrayList<>();

    public Expression(String expression) {
        this.separator = new Separator(expression);
        this.expression = validateExpression(extractformularExpression(expression));
        extractTerms(expression);
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
        String regex = "[" + NUMBER_REGEX + totalSeparator + "]*";
        return !expression.matches(regex);
    }

    private boolean hasCustomSeparator(String expression) {
        return expression.startsWith("//") && expression.contains("\\n");
    }

    private String extractActualExpression(String expression) {
        int start = expression.indexOf("\\n") + 2;
        return expression.substring(start);
    }

    private void extractTerms(String expression) {
        String formularExpression = extractformularExpression(expression);
        for (String part : formularExpression.split("[" + separator.getSeparator() + "]")) {
            terms.add(new Term(part.isEmpty() ? "0" : part));
        }
    }

    public List<Term> getTerms() {
        return terms;
    }
}
