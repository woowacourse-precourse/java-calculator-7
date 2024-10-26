package divide;

import static separate.Separator.CUSTOM;

public class CustomDivide implements Divide {	// 커스텀 구분자로 분리
	private static final int START_NUMBER_INDEX = 1;
	
	@Override
	public int[] divideNumbers(final String str) {
		// 커스텀 구분자를 구별하는 문자 제거 ("//", "\\n")
		String[] separators = CUSTOM.getSeparators();
		String cleanedStr = str.replace(separators[0], "").replace(separators[1], "");
		
		// 커스텀 구분자 추출
		String customSeparator = "\\" + cleanedStr.substring(0, START_NUMBER_INDEX);
		
		// 숫자 문자열 추출
		String numberStr = cleanedStr.substring(START_NUMBER_INDEX);
		
		// 커스텀 구분자로 숫자 분리
		String[] strArr = numberStr.split(customSeparator);
		
		// 숫자 배열로 변환하여 리턴
		return toIntArr(strArr);
	}
}
