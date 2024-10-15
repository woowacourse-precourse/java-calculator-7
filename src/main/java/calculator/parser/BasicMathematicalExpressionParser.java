package calculator.parser;

public class BasicMathematicalExpressionParser implements MathematicalExpressionParser {

	private int stringNumberToNumber(String stringNumber) {
		try {
			int number = Integer.parseInt(stringNumber);
			if (number <= 0) {
				throw new IllegalArgumentException("입력된 값이 양수가 아닙니다.");
			}
			return number;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("잘못된 문자로된 숫자입니다.");
		}

	}

	@Override
	public int[] parse(String text, String separatorRegex) {
		String[] stringNumbers = text.split(separatorRegex);
		int[] numbers = new int[stringNumbers.length];

		for(int i=0; i<stringNumbers.length; i++){
			numbers[i] = stringNumberToNumber(stringNumbers[i]);
		}

		return numbers;
	}
}
