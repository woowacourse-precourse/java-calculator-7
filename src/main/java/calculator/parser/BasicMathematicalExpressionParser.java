package calculator.parser;

import java.util.Arrays;

public class BasicMathematicalExpressionParser implements MathematicalExpressionParser {


	public static final String BASIC_VALID_MATHEMATICAL_EXPRESSION_PATTERN = "^(\\d)(\\D*\\d)*";

	private long stringNumberToNumber(String stringNumber) {
		try {
			long number = Long.parseLong(stringNumber);
			if (number <= 0) {
				throw new IllegalArgumentException(ParserError.INVALID_POSITIVE_NUMBER.getMessage());
			}
			return number;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ParserError.INVALID_FORMAT_NUMBER.getMessage());
		}

	}

	private void isValid(String expression){
		if(!expression.matches(BASIC_VALID_MATHEMATICAL_EXPRESSION_PATTERN)){
			throw new IllegalArgumentException("수식의 형태가 유효하지 않습니다.");
		}
	}

	@Override
	public long[] parse(String expression, String separatorPattern) {
		isValid(expression);
		String[] stringNumbers = expression.split(separatorPattern);

		return Arrays.stream(stringNumbers)
			.mapToLong(this::stringNumberToNumber)
			.toArray();
	}
}
