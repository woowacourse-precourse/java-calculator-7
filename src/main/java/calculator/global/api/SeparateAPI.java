package calculator.global.api;

import calculator.domain.Number;
import calculator.domain.Separator;
import calculator.global.config.BeanFactory;

import static calculator.global.constants.StaticString.REGEX_PATTERN;

public class SeparateAPI {
	private static final SeparateAPI INSTANCE = new SeparateAPI();
	private final Separator separator = BeanFactory.separator();
	private final JudgmentAPI judgmentAPI = BeanFactory.judgement();
	private final Number number = BeanFactory.number();

	private SeparateAPI(){}

	public boolean validSeparator(char sep) {
		for(int i = 0; i < separator.getSize(); i++) {
			if(separator.getSeparators(i).equals(sep)) {
				return true;
			}
		}
		return false;
	}

	private boolean findCustomSeparator(String sentence) {
		if(judgmentAPI.judgmentFormat(sentence)) {
			char customSeparator = sentence.replaceAll(REGEX_PATTERN.getString(), "$1").charAt(0);
			separator.addSeparator(customSeparator);
			return true;
		} else {
			return false;
		}
	}

	public String separateInput(String sentence) {
		if(findCustomSeparator(sentence)) {
			return sentence.replaceAll(REGEX_PATTERN.getString(), "$2");
		} else {
			return sentence;
		}
	}

	public void findNumbers(String sentence, boolean[] booleans) {
		int idx = 0;

		while(idx < sentence.length()) {

			if(booleans[idx]) {
				int trueCnt = judgmentAPI.judgmentContinuousTrue(booleans, idx);
				String sub = sentence.substring(idx, trueCnt + idx);
				number.addNumber(Integer.parseInt(sub));
				idx += trueCnt;
			} else if(validSeparator(sentence.charAt(idx))) {
				idx++;
			} else {
				throw new IllegalArgumentException("올바른 구분자가 아닙니다: " + sentence.charAt(idx));
			}
		}
	}

	public static SeparateAPI getInstance() {
		return INSTANCE;
	}
}
