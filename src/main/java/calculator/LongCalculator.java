package calculator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.operation.AdditionalLongCalculatorOperation;
import calculator.operation.LongCalculatorOperation;
import calculator.parser.BasicMathematicalExpressionParser;
import calculator.parser.BasicSeparatorParser;
import calculator.parser.MathematicalExpressionParser;
import calculator.parser.SeparatorParser;
import calculator.view.AdditionCalculatorView;

public class LongCalculator implements Calculator {
	private static final String VALID_CALCULATOR_EXPRESSION_PATTERN = "(^(/{2}\\D\\\\n)*)((\\d+\\D)*\\d+$)";
	private static final Pattern VALID_PATTERN = Pattern.compile(VALID_CALCULATOR_EXPRESSION_PATTERN);
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

	private long calculate(String expression, Set<Character> separators) {
		String[] expressions = splitBySeparatorExpressionAndMathematicalExpression(expression);

		System.out.println(expressions[0]);
		System.out.println(expressions[1]);

		separatorParser.parse(expressions[0], separators);
		String separatorPattern = separatorParser.generateRegex(separators);

		long[] numbers = mathematicalExpressionParser.parse(expressions[1], separatorPattern);
		long result = longCalculatorOperation.operate(numbers);

		return result;
	}

	private String[] splitBySeparatorExpressionAndMathematicalExpression(String expression){
		Matcher matcher = VALID_PATTERN.matcher(expression);
		if(matcher.find()){
			String separatorExpression = matcher.group(1);
			String mathematicalExpression = matcher.group(3);
			return new String[]{separatorExpression, mathematicalExpression};
		}
		else{
			throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
		}
	}

	private void isValid(String expression){
		if(!VALID_PATTERN.matcher(expression).matches()){
			throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
		}
	}

	@Override
	public void startCalculation() {
		String input = additionCalculatorView.input();

		long result = 0;
		if (!input.equals("")) {
			isValid(input);
			result = calculate(input, new HashSet<>());
		}

		additionCalculatorView.output(result);
	}

}
