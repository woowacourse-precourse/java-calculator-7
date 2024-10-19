package calculator.splitter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.core.CalculatorError;

public class ExpressionSplitter {

	private final String VALID_EXPRESSION_PATTERN;
	private final Pattern VALID_PATTERN;

	public ExpressionSplitter(String separatorPattern, String mathematicalExpressionPattern) {
		String pattern = String.format("(%s)(%s)", separatorPattern, mathematicalExpressionPattern);
		this.VALID_EXPRESSION_PATTERN = pattern;
		VALID_PATTERN = Pattern.compile(VALID_EXPRESSION_PATTERN);
	}

	public String[] splitExpression(String expression) {
		Matcher matcher = VALID_PATTERN.matcher(expression);
		if (matcher.find()) {
			String separatorExpression = matcher.group(1);
			String mathematicalExpression = matcher.group(3);
			return new String[] {separatorExpression, mathematicalExpression};
		} else {
			throw new IllegalArgumentException(CalculatorError.INVALID_INPUT.getMessage());
		}
	}

	public void isValid(String expression) {
		if (!VALID_PATTERN.matcher(expression).matches()) {
			throw new IllegalArgumentException(CalculatorError.INVALID_INPUT.getMessage());
		}
	}

}
