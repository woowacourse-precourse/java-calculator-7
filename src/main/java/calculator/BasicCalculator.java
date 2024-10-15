package calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import calculator.parser.BasicMathematicalExpressionParser;
import calculator.parser.BasicSeparatorParser;
import calculator.parser.MathematicalExpressionParser;
import calculator.parser.SeparatorParser;

public class BasicCalculator implements Calculator {

	private Set<String> separators;
	private static final String[] BASIC_SEPARATORS = {",", ":"};
	private SeparatorParser separatorParser;
	private MathematicalExpressionParser mathematicalExpressionParser;
	private int recentResult;

	public BasicCalculator() {
		this(null, null);
	}

	public BasicCalculator(SeparatorParser separatorParser) {
		this(separatorParser, null);
	}

	public BasicCalculator(MathematicalExpressionParser mathematicalExpressionParser) {
		this(null, mathematicalExpressionParser);
	}

	public BasicCalculator(SeparatorParser separatorParser, MathematicalExpressionParser mathematicalExpressionParser) {
		if(separatorParser == null){
			this.separatorParser = new BasicSeparatorParser();
		}
		if(mathematicalExpressionParser == null){
			this.mathematicalExpressionParser = new BasicMathematicalExpressionParser();
		}
		separators = new HashSet<>(Arrays.asList(BASIC_SEPARATORS));
	}

	@Override
	public void calculate(String expression) {
		String mathematicalExpression = separatorParser.parse(expression, separators);
		String separatorRegex = separatorParser.generateRegex(separators);
		int[] numbers = mathematicalExpressionParser.parse(mathematicalExpression, separatorRegex);

		int result = 0;
		for (int number : numbers) {
			result += number;
		}

		recentResult = result;
	}
}
