package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
	private String inputStr;
	private long totalSum;
	private final char[] separator = new char[3];
	private int separatorCnt;

	public Calculator() {
		inputStr = "";
		totalSum = 0;
		separator[0] = ',';
		separator[1] = ':';
		separatorCnt = 2;
	}

	public void run() {
		enter();
		checkPersonalSeparator(inputStr);
		parsingNumsAndCalculate(inputStr);
		print();
	}

	/*
		입력
	 */
	private void enter() {
		System.out.println("덧셈할 문자열을 입력해 주세요.");
		inputStr = Console.readLine();
		Console.close();
	}

	/*
		출력
	 */
	private void print() {
		System.out.println("결과 : " + totalSum);
	}

	/*
		숫자 계산
	 */
	private void calculateNums(long num) {
		totalSum += num;
	}

	/*
		커스텀 구분자 확인 및 저장
	 */
	private void checkPersonalSeparator(String str) {
		int startPos = str.indexOf("//");
		int endPos = str.indexOf("\\n");

		// 커스텀 구분자를 지정하지 않을 때
		if (startPos == -1 && endPos == -1) {
			return;
		}

		// 커스텀 구분자가 처음에 위치하지 않거나, 커스텀 구분자로 1개 이상의 문자 입력 시
		if (startPos != 0 || endPos != 3) {
			throw new IllegalArgumentException();
		}

		// 커스텀 구분자로 숫자가 들어왔을 때
		char newSeparator = str.charAt(2);
		if (Character.isDigit(newSeparator)) {
			throw new IllegalArgumentException("숫자는 커스텀 구분자로 사용할 수 없습니다.");
		}

		// 커스텀 구분자 지정 부분 문자열 제거
		inputStr = inputStr.substring(5);

		savePersonalSeparator(newSeparator);
	}

	private void savePersonalSeparator(char personalSeparator) {
		// 커스텀 구분자 저장 및 구분자 개수 추가
		separator[2] = personalSeparator;
		separatorCnt++;
	}

	/*
		문자열을 숫자로 전환
	 */
	private long stringToLong(String strNum) {
		long num = Long.parseLong(strNum);

		// 숫자가 정수형 범위를 넘어섰을 때
		if (num < Integer.MIN_VALUE || Integer.MAX_VALUE < num) {
			throw new IllegalArgumentException("숫자는 int형 범위 내에서 입력 가능합니다.");
		}
		return num;
	}

	/*
		문자열 파싱 및 계산
	 */
	private void parsingNumsAndCalculate(String str) {
		if (str.length() == 0) {
			return;
		}
		// 처음과 끝에 구분자가 나올 때
		if (!Character.isDigit(str.charAt(0))
				|| !Character.isDigit(str.charAt(str.length() - 1))) {
			throw new IllegalArgumentException("구분자는 문자열의 앞 또는 뒤에 위치할 수 없습니다.");
		}

		int startIdx = 0, endIdx = 0, strLen = str.length();
		while (endIdx < strLen) {
			while (endIdx < strLen && Character.isDigit(str.charAt(endIdx))) {
				endIdx++;
			}

			// 구분자 2개 이상
			if (startIdx == endIdx) {
				throw new IllegalArgumentException("구분자는 하나씩만 사용 가능합니다.");
			}

			long num = stringToLong(str.substring(startIdx, endIdx));

			if (endIdx == strLen) {
				calculateNums(num);
				return;
			}

			// 구분자 이외의 문자 입력 시 에러
			int idx = 0;
			while (idx < separatorCnt) {
				if (str.charAt(endIdx) == separator[idx]) {
					break;
				}
				idx++;
			}
			if (idx == separatorCnt) {
				throw new IllegalArgumentException("지정되지 않은 구분자는 사용할 수 없습니다.");
			}

			calculateNums(num);
			endIdx++;
			startIdx = endIdx;
		}
	}
}
