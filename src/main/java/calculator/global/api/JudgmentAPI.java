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

	public boolean[] judgmentNumbers(char[] charArrays) {
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

    public int judgmentContinuousTrue(boolean[] booleans, int idx) {
		int booleansLength = booleans.length;
		int continuousTrue = 1;

		for(int i = idx; i < booleansLength-1; i++) {
			if(booleans[i] && judgmentNextTrue(booleans, i)) {
				continuousTrue++;
			} else {
				return continuousTrue;
			}
		}

		return continuousTrue;
	}

	private boolean judgmentNextTrue(boolean[] booleans, int idx) {
		return booleans[idx] && booleans[idx+1];
	}

	public static JudgmentAPI getInstance() {
		return INSTANCE;
	}
}
