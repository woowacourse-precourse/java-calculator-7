package calculator.core;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.operation.AdditionalLongCalculatorOperation;
import calculator.operation.LongCalculatorOperation;
import calculator.parser.LongMathematicalExpressionParser;
import calculator.parser.BasicSeparatorParser;
import calculator.parser.MathematicalExpressionParser;
import calculator.parser.SeparatorParser;
import calculator.view.AdditionCalculatorView;
import calculator.view.CalculatorView;

public class LongCalculator implements Calculator {
	private static final String VALID_CALCULATOR_EXPRESSION_PATTERN = "(^(/{2}\\D\\\\n)*)((\\d+\\D)*\\d+$)";
	private static final Pattern VALID_PATTERN = Pattern.compile(VALID_CALCULATOR_EXPRESSION_PATTERN);
	private final SeparatorParser separatorParser;
	private final MathematicalExpressionParser mathematicalExpressionParser;
	private final CalculatorView calculatorView;
	private final LongCalculatorOperation longCalculatorOperation;

	public LongCalculator() {
		this(new BasicSeparatorParser(), new LongMathematicalExpressionParser(),
			new AdditionCalculatorView(), new AdditionalLongCalculatorOperation());
	}

	public LongCalculator(
		SeparatorParser separatorParser,
		MathematicalExpressionParser mathematicalExpressionParser,
		CalculatorView calculatorView,
		LongCalculatorOperation longCalculatorOperation
	) {
		this.separatorParser = separatorParser;
		this.mathematicalExpressionParser = mathematicalExpressionParser;
		this.calculatorView = calculatorView;
		this.longCalculatorOperation = longCalculatorOperation;
	}

	private long calculate(String expression, Set<Character> separators) {
		String[] expressions = splitExpression(expression);

		separatorParser.parse(expressions[0], separators);
		String separatorRegex = separatorParser.generateRegex(separators);

		long[] numbers = mathematicalExpressionParser.parse(expressions[1], separatorRegex);
		long result = longCalculatorOperation.operate(numbers);

		return result;
	}

	private String[] splitExpression(String expression) {
		Matcher matcher = VALID_PATTERN.matcher(expression);
		if (matcher.find()) {
			String separatorExpression = matcher.group(1);
			String mathematicalExpression = matcher.group(3);
			return new String[] {separatorExpression, mathematicalExpression};
		} else {
			throw new IllegalArgumentException(CalculatorError.INVALID_INPUT.getMessage());
		}
	}

	private void isValid(String expression) {
		if (!VALID_PATTERN.matcher(expression).matches()) {
			throw new IllegalArgumentException(CalculatorError.INVALID_INPUT.getMessage());
		}
	}

	@Override
	public void startCalculation() {
		String input = calculatorView.input();

		long result = 0;
		if (!input.equals("")) {
			isValid(input);
			result = calculate(input, new HashSet<>());
		}

		calculatorView.output(Long.toString(result));
	}

}
