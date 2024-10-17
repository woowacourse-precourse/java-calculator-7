package calculator.global.api;

import calculator.domain.Separator;
import calculator.global.config.APIFactory;

import static calculator.global.constants.StaticString.REGEX_PATTERN;

public class SeparateAPI {
	private final Separator separator;
	private static final SeparateAPI INSTANCE = new SeparateAPI();

	private SeparateAPI(){
		separator = Separator.getInstance();
	}

	public void findCustomSeparator(String sentence) {
		if(APIFactory.judgement().judgmentFormat(sentence)) {
			char customSeparator = sentence.replaceAll(REGEX_PATTERN.getString(), "$1").charAt(0);
			separator.addSeparator(customSeparator);
		}
	}

	public void findNumberAndSave() {
	}

	public static SeparateAPI getInstance() {
		return INSTANCE;
	}
}
