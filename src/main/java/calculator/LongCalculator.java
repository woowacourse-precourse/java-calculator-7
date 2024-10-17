package calculator;

import java.util.HashSet;
import java.util.Set;

import calculator.operation.AdditionalLongCalculatorOperation;
import calculator.operation.LongCalculatorOperation;
import calculator.parser.BasicMathematicalExpressionParser;
import calculator.parser.BasicSeparatorParser;
import calculator.parser.MathematicalExpressionParser;
import calculator.parser.SeparatorParser;
import calculator.view.AdditionCalculatorView;

public class LongCalculator implements Calculator {

	private static final Set<Character> separators = new HashSet<>();
	private final SeparatorParser separatorParser;
	private final MathematicalExpressionParser mathematicalExpressionParser;
	private final AdditionCalculatorView additionCalculatorView;
	private final LongCalculatorOperation longCalculatorOperation;

	public LongCalculator() {
		this(new BasicSeparatorParser(), new BasicMathematicalExpressionParser(),
			new AdditionCalculatorView(), new AdditionalLongCalculatorOperation());
	}

	public LongCalculator(
		SeparatorParser separatorParser,
		MathematicalExpressionParser mathematicalExpressionParser,
		AdditionCalculatorView additionCalculatorView,
		LongCalculatorOperation longCalculatorOperation
	) {
		this.separatorParser = separatorParser;
		this.mathematicalExpressionParser = mathematicalExpressionParser;
		this.additionCalculatorView = additionCalculatorView;
		this.longCalculatorOperation = longCalculatorOperation;
	}

	private long calculate(String expression) {
		String mathematicalExpression = separatorParser.parse(expression, separators);
		String separatorPattern = separatorParser.generateRegex(separators);
		long[] numbers = mathematicalExpressionParser.parse(mathematicalExpression, separatorPattern);
		long result = longCalculatorOperation.operate(numbers);
		return result;
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
