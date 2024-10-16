package calculator.global.api;

import calculator.domain.Separator;

import java.util.ArrayList;
import java.util.List;

public class SeparateAPI {
	private Separator separator = Separator.getInstance();
	private final String regexPattern = "^//(.)\\n.*$";

	public void findCustomSeparator(String sentence) {
		if(sentence.matches(regexPattern)) {
			char customSeparator = sentence.replaceAll(regexPattern, "$1").charAt(0);
			separator.addSeparator(customSeparator);
		}
	}
}
