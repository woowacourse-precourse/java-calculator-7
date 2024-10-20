package divide;

import java.util.Arrays;

public interface Divide {
	int[] divideNumbers(final String str);
	
	// 문자열 배열을 숫자 배열로 변경하는 디폴트 메서드
	default int[] toIntArr(final String[] strArr) {
		return Arrays.stream(strArr)
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}
