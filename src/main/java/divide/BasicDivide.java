package divide;

import static separate.Separator.BASIC;

public class BasicDivide implements Divide {	// 기본 구분자로 분리
	@Override
	public int[] divideNumbers(final String str) {
		String[] strArr = {};
		
		if (BASIC.hasOneSeparators(str)) {
			strArr = str.split("[,:]");
		} else if (str.equals("")) {
			strArr = new String[] {"0"};
		} else {
			strArr = new String[] {str};
		}
		
		return toIntArr(strArr);	// 숫자 배열로 변환하여 리턴
	}
}
