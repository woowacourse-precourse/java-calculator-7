package calculator.global.api;

import calculator.domain.Separator;

import static calculator.global.constants.StaticString.REGEX_PATTERN;

public class SeparateAPI {
	private final Separator separator;
	private static final SeparateAPI INSTANCE = new SeparateAPI();

	private SeparateAPI(){
		separator = Separator.getInstance();
	}

	public boolean findCustomSeparator(String sentence) {
		if(sentence.matches(REGEX_PATTERN.getString())) {
			char customSeparator = sentence.replaceAll(REGEX_PATTERN.getString(), "$1").charAt(0);
			separator.addSeparator(customSeparator);
			return true;
		}

		return false;
	}

	public Separator getSeparator() {
		return separator;
	}

	public static SeparateAPI getInstance() {
		return INSTANCE;
	}
}
