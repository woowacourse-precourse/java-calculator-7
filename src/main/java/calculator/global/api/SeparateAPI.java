package calculator.global.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SeparateAPI {

	private List<Character> separators = new ArrayList<>();
	private final String regexPattern = "^//(.)\\n.*$";

	private SeparateAPI() {
		separators.add(',');
		separators.add(':');
	}

	public Character findCustomSeparator(String sentence) {
		if(sentence.matches(regexPattern)) {
			char separator = sentence.replaceAll(regexPattern, "$1").charAt(0);
			separators.add(separator);
			return separator;
		} else {
			return null;
		}
	}
}
