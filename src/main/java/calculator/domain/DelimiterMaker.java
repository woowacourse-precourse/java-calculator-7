package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class DelimiterMaker {

	private static final String DEFAULT_DELIMITER_COMMA = ",";
	private static final String DEFAULT_DELIMITER_COLON = ":";
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

	public List<String> getDelimitersFrom(String delimiterMixedNumbers) {

		List<String> delimiters = new ArrayList<>(Arrays.asList(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON));

		String delimiter = getDelimiterStringFrom(delimiterMixedNumbers);
		String[] split = delimiter.split(Pattern.quote(CUSTOM_DELIMITER_SUFFIX));
		Arrays.stream(split)
			.filter(separator -> separator.contains(CUSTOM_DELIMITER_PREFIX))
			.map(separator -> separator.replace(CUSTOM_DELIMITER_PREFIX, ""))
			.forEach(delimiters::add);

		return delimiters;
	}

	public String getDelimiterStringFrom(String delimiterMixedNumbers) {
		return delimiterMixedNumbers.substring(delimiterMixedNumbers.lastIndexOf(CUSTOM_DELIMITER_SUFFIX) + 1);
	}

	public boolean hasCustomSeparator(String input) {
		return input.contains(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX);
	}

}
