package calculator.splitter;

import calculator.model.CalculatorModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionSplitter {

    private final String VALID_EXPRESSION_PATTERN;
    private final Pattern VALID_PATTERN;

    public ExpressionSplitter(String separatorPattern, String mathematicalExpressionPattern) {
        String pattern = String.format("(%s)(%s)", separatorPattern, mathematicalExpressionPattern);
        this.VALID_EXPRESSION_PATTERN = pattern;
        VALID_PATTERN = Pattern.compile(VALID_EXPRESSION_PATTERN);
    }

    public void splitExpression(CalculatorModel model) {
        isValid(model.getInput());
        Matcher matcher = VALID_PATTERN.matcher(model.getInput());
        if (matcher.find()) {
            String separatorExpression = matcher.group(1);
            String mathematicalExpression = matcher.group(3);

            model.setSeparatorExpression(separatorExpression);
            model.setMathematicalExpression(mathematicalExpression);
        } else {
            throw new IllegalArgumentException(ExpressionSplitterError.INVALID_EXPRESSION.getMessage());
        }
    }

    private void isValid(String input) {
        if (!VALID_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ExpressionSplitterError.INVALID_EXPRESSION.getMessage());
        }
    }

}
