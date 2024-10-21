package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ExpressionSplitter {

    private final Pattern delimiterPattern;
    private final String operationalExpression;

    public ExpressionSplitter(Pattern delimiterPattern, String operationalExpression) {
        this.delimiterPattern = delimiterPattern;
        this.operationalExpression = operationalExpression;
    }

    public List<String> splitOperationalExpressionByDelimiters() {
        return Arrays.stream(delimiterPattern.split(operationalExpression))
                .toList();
    }
}