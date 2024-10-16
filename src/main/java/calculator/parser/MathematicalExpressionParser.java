package calculator.parser;

public interface MathematicalExpressionParser {

	public long[] parse(String text, String separatorRegex);
}
