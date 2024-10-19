package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
	private List<String> separators = new ArrayList<>(Arrays.asList(",", ";"));

	/**
	 * 커스텀 구분자 확인
	 *
	 * @param inputStr
	 */
	public boolean isPersonalSeparatorExist(String inputStr) {
		int startPos = inputStr.indexOf("//");
		int endPos = inputStr.indexOf("\\n");

		// 커스텀 구분자를 지정하지 않을 때
		if (startPos == -1 && endPos == -1) {
			return false;
		}

		// 커스텀 구분자가 처음에 위치하지 않거나, 커스텀 구분자로 1개 이상의 문자 입력 시
		if (startPos != 0 || endPos != 3) {
			throw new IllegalArgumentException("커스텀 구분자는 처음에 위치해야 하며, 1개 이상 입력할 수 없습니다.");
		}

		// 커스텀 구분자로 숫자가 들어왔을 때
		char newSeparator = inputStr.charAt(2);
		if (Character.isDigit(newSeparator)) {
			throw new IllegalArgumentException("숫자는 커스텀 구분자로 사용할 수 없습니다.");
		}

		return true;
	}

	/**
	 * 커스텀 구분자 저장
	 *
	 * @param personalSeparator
	 */
	public void savePersonalSeparator(String personalSeparator) {
		separators.add(personalSeparator);
	}

	/**
	 * 구분자를 기준으로 문자열 파싱
	 *
	 * @param inputStr
	 */
	public String[] parseBySeparator(String inputStr) {
		String[] splitStr = new String[0];

		if (!inputStr.isEmpty()) {
			String regex = String.join("|", separators);
			splitStr = inputStr.split(regex);
		}
		return splitStr;
	}
}