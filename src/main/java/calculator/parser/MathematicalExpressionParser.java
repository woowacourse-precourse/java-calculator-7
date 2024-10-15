package calculator.parser;

public interface MathematicalExpressionParser {

	public int[] parse(String text, String separatorRegex);
}
