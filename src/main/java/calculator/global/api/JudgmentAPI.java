package calculator.global.api;

import static calculator.global.constants.StaticString.REGEX_PATTERN;

public class JudgmentAPI {
	private static final JudgmentAPI INSTANCE = new JudgmentAPI();

	private JudgmentAPI() {}

	public boolean judgmentNumber(Character ch) {
		return true;
	}

	public boolean judgmentFormat(String sentence) {
		return sentence.matches(REGEX_PATTERN.getString());
	}

    public int isNextTrue(Boolean[] booleans, int init) {
		int arrayLength = booleans.length;
		int continuousTrue = 0;

		for(int i = init; i < arrayLength; i++) {
			if(booleans[i]) {
				continuousTrue++;
			} else {
				return continuousTrue;
			}
		}

		return continuousTrue;
	}

	public static JudgmentAPI getInstance() {
		return INSTANCE;
	}
}
