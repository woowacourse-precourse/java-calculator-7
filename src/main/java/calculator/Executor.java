package calculator;

import java.util.Objects;

public class Executor {
	private IOController ioController;
	private Parser parser;
	private Calculator calculator;

	/**
	 * 생성자
	 *
	 * @param ioController : 입출력 기능
	 * @param parser       : 문자열 파싱 기능
	 * @param calculator   : 계산 기능
	 */
	Executor(IOController ioController, Parser parser, Calculator calculator) {
		this.ioController = ioController;
		this.parser = parser;
		this.calculator = calculator;
	}

	/**
	 * 구분자 에러 확인
	 *
	 * @param splitStr
	 */
	private void checkSeparatorErrors(String[] splitStr) {
		// check 구분자 에러
		for (String s : splitStr) {
			if (Objects.equals(s, "")) {
				throw new IllegalArgumentException("구분자는 문자열의 앞 또는 뒤에 위치할 수 없습니다.");
			}

			try {
				Integer.parseInt(s);
			} catch (Exception e) {
				throw new IllegalArgumentException("지정되지 않은 구분자는 사용할 수 없습니다.");
			}
		}
	}
}
