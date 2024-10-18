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

	public void findCustomSeparator(String sentence) {
		if(BeanFactory.judgement().judgmentFormat(sentence)) {
			char customSeparator = sentence.replaceAll(REGEX_PATTERN.getString(), "$1").charAt(0);
			separator.addSeparator(customSeparator);
		}
	}

	public void findNumberAndSave(String sentence) {
		boolean[] booleans = judgmentAPI.convertBooleanTypeNumbers(sentence.toCharArray());
		int idx = 0;
		
		while(idx < sentence.length()) {
			if(booleans[idx]) {
				int nextTrue = judgmentAPI.isNextTrue(booleans, idx);
				String sub = sentence.substring(idx, nextTrue );
				number.addNumber(Integer.parseInt(sub));
			} else {
				char separator = sentence.charAt(idx);
				if(!validSeparator(separator)) {
					throw new IllegalArgumentException("올바른 구분자가 아닙니다");
				}
			}
		}
	}

	public static SeparateAPI getInstance() {
		return INSTANCE;
	}
}
