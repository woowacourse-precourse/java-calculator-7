package calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import calculator.parser.BasicMathematicalExpressionParser;
import calculator.parser.BasicSeparatorParser;
import calculator.parser.MathematicalExpressionParser;
import calculator.parser.SeparatorParser;
import camp.nextstep.edu.missionutils.Console;

public class BasicCalculator implements Calculator {

	private Set<Character> separators;
	private static final Character[] BASIC_SEPARATORS = {',', ':'};
	private SeparatorParser separatorParser;
	private MathematicalExpressionParser mathematicalExpressionParser;

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
		if (separatorParser == null) {
			this.separatorParser = new BasicSeparatorParser();
		}
		if (mathematicalExpressionParser == null) {
			this.mathematicalExpressionParser = new BasicMathematicalExpressionParser();
		}
		separators = new HashSet<>(Arrays.asList(BASIC_SEPARATORS));
	}
	private long calculate(String expression) {
		String mathematicalExpression = separatorParser.parse(expression, separators);
		String separatorRegex = separatorParser.generateRegex(separators);
		long[] numbers = mathematicalExpressionParser.parse(mathematicalExpression, separatorRegex);

		return Arrays.stream(numbers).sum();
	}

	@Override
	public void startCalculation() {
		System.out.println("덧셈할 문자열을 입력해 주세요.");
		String input = Console.readLine();

		long result = calculate(input);

		System.out.printf("결과 : %d", result);
	}

}
