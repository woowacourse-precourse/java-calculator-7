package calculator;

import calculator.exception.SeparatorNotExistException;

public class InputStringProcessor {

	private static final int BEGIN_INDEX = 0;
	private static final int SEPARATOR_CRITERIA = 4;
	private static final String SEPARATOR_FORM_BEGIN_STR = "//";
	private static final String SEPARATOR_FORM_END_STR = "\n";
	private static final int SEPARATOR_LOCATION_INDEX = 2;

	public String removeFirstFiveCharacters(String strWithCustomSeparator) {
		return strWithCustomSeparator.substring(SEPARATOR_CRITERIA);
	}

	public String getFirstFiveCharacters(String strWithMinFiveChars) {
		return strWithMinFiveChars.substring(BEGIN_INDEX, SEPARATOR_CRITERIA);
	}

	public Character getSeparator(String firstFiveCharacters) {
		validateSeparatorForm(firstFiveCharacters);
		return firstFiveCharacters.charAt(SEPARATOR_LOCATION_INDEX);
	}

	private void validateSeparatorForm(String firstFiveCharacters) {
		if (!firstFiveCharacters.startsWith(SEPARATOR_FORM_BEGIN_STR) ||
			!firstFiveCharacters.endsWith(SEPARATOR_FORM_END_STR)) {
			throw new SeparatorNotExistException(firstFiveCharacters);
		}
	}
}