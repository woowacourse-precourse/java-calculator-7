package calculator.parser;

public interface LongMathematicalExpressionParser {

	public long[] parse(String text, String separatorRegex);
}
