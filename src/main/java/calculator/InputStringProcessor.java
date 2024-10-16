package calculator;

public class InputStringProcessor {

	private static final int BEGIN_INDEX = 4;

	public String removeFirstFiveCharacters(String strWithMinFiveChars) {
		return strWithMinFiveChars.substring(BEGIN_INDEX);
	}
}