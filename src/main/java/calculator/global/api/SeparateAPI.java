package calculator.global.api;

import calculator.domain.Separator;

public class SeparateAPI {
	private final Separator separator = Separator.getInstance();
	private final String regexPattern = "^//(.)\\n.*$";

	public boolean findCustomSeparator(String sentence) {
		if(sentence.matches(regexPattern)) {
			char customSeparator = sentence.replaceAll(regexPattern, "$1").charAt(0);
			separator.addSeparator(customSeparator);
			return true;
		}

		return false;
	}
}
