package calculator.parser;

public class BasicMathematicalExpressionParser implements MathematicalExpressionParser {

	private int stringNumberToNumber(String stringNumber) {
		try {
			int number = Integer.parseInt(stringNumber);
			if (number <= 0) {
				throw new IllegalArgumentException(ParserError.INVALID_POSITIVE_NUMBER.getMessage());
			}
			return number;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ParserError.INVALID_FORMAT_NUMBER.getMessage());
		}

	}

	@Override
	public int[] parse(String text, String separatorRegex) {
		String[] stringNumbers = text.split(separatorRegex);
		int[] numbers = new int[stringNumbers.length];

		for (int i = 0; i < stringNumbers.length; i++) {
			numbers[i] = stringNumberToNumber(stringNumbers[i]);
		}

		return numbers;
	}
}
