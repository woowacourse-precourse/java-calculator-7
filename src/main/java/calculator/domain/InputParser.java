package calculator.domain;

public class InputParser {

	private static final int STRING_START_INDEX = 0;

	public String getDelimiterSectionFrom(String delimiterMixedNumbers, String delimiterEndSign) {
		int delimiterSectionEndIndex = delimiterMixedNumbers.lastIndexOf(delimiterEndSign);
		return delimiterMixedNumbers.substring(STRING_START_INDEX, delimiterSectionEndIndex);
	}

	public String getNumberSectionFrom(String numbersMixedDelimiters, String delimiterEndSign) {
		int numberSectionStartIndex =
			numbersMixedDelimiters.lastIndexOf(delimiterEndSign) + delimiterEndSign.length();
		return numbersMixedDelimiters.substring(numberSectionStartIndex);
	}
}
