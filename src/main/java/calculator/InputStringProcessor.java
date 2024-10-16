package calculator;

public class InputStringProcessor {

	private static final int BEGIN_INDEX = 0;
	private static final int SEPARATOR_CRITERIA = 4;

	public String removeFirstFiveCharacters(String strWithCustomSeparator) {
		return strWithCustomSeparator.substring(SEPARATOR_CRITERIA);
	}
	
	public String getFirstFiveCharacters(String strWithMinFiveChars) {
		return strWithMinFiveChars.substring(BEGIN_INDEX, SEPARATOR_CRITERIA);
	}
}