package validate;

import static separate.Separator.BASIC;
import static separate.Separator.CUSTOM;

public class ValidateImpl implements Validate {
	public boolean isValid(final String str) {	// 입력받은 문자열이 유효한지 검사
		// 음수 사용 불가
		if (str.contains("-")) {
			return false;
		}
		
		// 숫자 0으로 치환 가능
		if (str.equals("")) {
			return true;
		}
		
		// 커스텀 구분자 사용 가능
		if (CUSTOM.hasAllSeparators(str)) {
			return true;
		}
		
		// 기본 구분자 사용 가능
		if (BASIC.hasOneSeparators(str)) {
			return true;
		}
		
		// 문자열이 숫자로만 이루어져 있으면 가능
		if (str.matches("\\d+")) {
			return true;
		}
		
		return false;	// 이 외에는 모두 유효성에 어긋남
	}
}
