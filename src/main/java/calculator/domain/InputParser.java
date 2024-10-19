package calculator.domain;

public class InputParser {

	private static final String DELIMITER_SECTION_END_SIGN = "\\n";
	private static final int STRING_START_INDEX = 0;

	public String getDelimiterSectionFrom(String delimiterMixedNumbers) {
		int delimiterSectionEndIndex = delimiterMixedNumbers.lastIndexOf(DELIMITER_SECTION_END_SIGN);
		return delimiterMixedNumbers.substring(STRING_START_INDEX, delimiterSectionEndIndex);
	}

	public String getNumberSectionFrom(String numbersMixedDelimiters) {
		int numberSectionStartIndex =
			numbersMixedDelimiters.lastIndexOf(DELIMITER_SECTION_END_SIGN) + DELIMITER_SECTION_END_SIGN.length();
		return numbersMixedDelimiters.substring(numberSectionStartIndex);
	}
}
