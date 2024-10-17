package calculator.global.api;

import static calculator.global.constants.StaticString.REGEX_PATTERN;

public class JudgmentAPI {
	private static final JudgmentAPI INSTANCE = new JudgmentAPI();

	private JudgmentAPI() {}

	private boolean judgmentNumber(Character ch) {
		for(char c = '0'; c <= '9'; c++) {
			if(ch.equals(c)) {
				return true;
			}
		}
		return false;
	}

	public boolean[] booleanTypeNumbers(Character[] charArrays) {
		boolean[] booleans = new boolean[charArrays.length];
		int idx = 0;

		for(char c : charArrays) {
			if(judgmentNumber(c)) {
				booleans[idx] = true;
			} else {
				booleans[idx] = false;
			}
			idx++;
		}

		return booleans;
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
