package validate;

import static separate.Separator.*;

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
		
		String[] separators = BASIC.getSeparators();	// 기본 구분자 2개
		
		// 숫자나 기본 구분자가 아닌 올바르지 않은 구분자가 포함되어있다면 불가
		return str.chars()
				.filter(ch -> ch < '0' || ch > '9')	// 숫자가 아닌 문자만 필터링
				.allMatch(ch -> ch == separators[0].charAt(0) || ch == separators[1].charAt(0));	// 기본 구분자와 일치 여부 확인
	}
}
