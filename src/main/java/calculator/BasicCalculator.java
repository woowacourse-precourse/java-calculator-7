package calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import calculator.parser.BasicMathematicalExpressionParser;
import calculator.parser.BasicSeparatorParser;
import calculator.parser.MathematicalExpressionParser;
import calculator.parser.SeparatorParser;
import calculator.view.AdditionCalculatorView;
import camp.nextstep.edu.missionutils.Console;

public class BasicCalculator implements Calculator {

	private static final Set<Character> separators = new HashSet<>();
	private final SeparatorParser separatorParser;
	private final MathematicalExpressionParser mathematicalExpressionParser;
	private final AdditionCalculatorView additionCalculatorView;

	public BasicCalculator() {
		this(new BasicSeparatorParser(), new BasicMathematicalExpressionParser(), new AdditionCalculatorView());
	}

	public BasicCalculator(
		SeparatorParser separatorParser,
		MathematicalExpressionParser mathematicalExpressionParser,
		AdditionCalculatorView additionCalculatorView
	) {
		this.separatorParser = separatorParser;
		this.mathematicalExpressionParser = mathematicalExpressionParser;
		this.additionCalculatorView = additionCalculatorView;
	}

	private long calculate(String expression) {
		String mathematicalExpression = separatorParser.parse(expression, separators);
		String separatorPattern = separatorParser.generateRegex(separators);
		long[] numbers = mathematicalExpressionParser.parse(mathematicalExpression, separatorPattern);

		return Arrays.stream(numbers).sum();
	}

	@Override
	public void startCalculation() {
		String input = additionCalculatorView.input();

		long result = 0;
		if (!input.equals("")) {
			result = calculate(input);
		}

		separators.clear();
		additionCalculatorView.output(result);
	}

}
