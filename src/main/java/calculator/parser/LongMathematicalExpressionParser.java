package calculator.parser;

import java.util.Set;

public interface LongMathematicalExpressionParser {

	public long[] parse(String expression, Set<Character> separators);

	public String getVALID_MATHEMATICAL_EXPRESSION_PATTERN();
}
