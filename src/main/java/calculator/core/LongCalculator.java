package calculator.core;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import calculator.operation.AdditionalLongCalculatorOperation;
import calculator.operation.LongCalculatorOperation;
import calculator.parser.BasicLongMathematicalExpressionParser;
import calculator.parser.BasicSeparatorParser;
import calculator.parser.LongMathematicalExpressionParser;
import calculator.parser.SeparatorParser;
import calculator.splitter.ExpressionSplitter;
import calculator.view.AdditionCalculatorView;
import calculator.view.CalculatorView;

public class LongCalculator implements Calculator {
	private final SeparatorParser separatorParser;
	private final LongMathematicalExpressionParser mathematicalExpressionParser;
	private final CalculatorView calculatorView;
	private final LongCalculatorOperation longCalculatorOperation;
	private final ExpressionSplitter expressionSplitter;

	public LongCalculator() {
		this(new BasicSeparatorParser(), new BasicLongMathematicalExpressionParser(),
			new AdditionCalculatorView(), new AdditionalLongCalculatorOperation());
	}

	public LongCalculator(
		SeparatorParser separatorParser,
		LongMathematicalExpressionParser mathematicalExpressionParser,
		CalculatorView calculatorView,
		LongCalculatorOperation longCalculatorOperation
	) {
		this.separatorParser = separatorParser;
		this.mathematicalExpressionParser = mathematicalExpressionParser;
		this.calculatorView = calculatorView;
		this.longCalculatorOperation = longCalculatorOperation;
		this.expressionSplitter = new ExpressionSplitter(
			separatorParser.getVALID_CUSTOM_SEPARATOR_PATTERN(),
			mathematicalExpressionParser.getVALID_MATHEMATICAL_EXPRESSION_PATTERN());
	}

	private long calculate(String expression, Set<Character> separators) {
		String[] expressions = expressionSplitter.splitExpression(expression);

		separatorParser.parse(expressions[0], separators);

		long[] numbers = mathematicalExpressionParser.parse(expressions[1], separators);
		long result = longCalculatorOperation.operate(numbers);

		return result;
	}

	@Override
	public void startCalculation() {
		String input = calculatorView.input();

		long result = 0;
		if (!input.equals("")) {
			expressionSplitter.isValid(input);
			result = calculate(input, new HashSet<>());
		}

		calculatorView.output(Long.toString(result));
	}

}
