package calculator.global.api;

import calculator.domain.Separator;
import calculator.global.config.BeanFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparateAPITest {
	private final SeparateAPI separateAPI = BeanFactory.separate();
	private final Separator separator = BeanFactory.separator();
	private final CalculatorAPI calculatorAPI = BeanFactory.calculator();

	@Test
	@DisplayName("커스텀 구분자가 있을 경우")
	void findCustomSeparator() {
		//given
		String sentence = "//;\n1;2;3";

		//when
		separateAPI.findCustomSeparator(sentence);
		Character c = separator.getSeparators(2);

		//then
		assertEquals(';', c);

		// 1. separators 에 값이 추가가 안되는 문제
		// - format 에 맞지 않아 separate 에서 못 찾는 걸 수도 있음
		// - findCustomSeparator 문제
		// sol) input 이 잘못 주어짐
	}

	@Test
	@DisplayName("커스텀 구분자 문자가 아닌 문자열일 경우")
	void validCustomSeparator() {
		//given
		String sentence = "//;;\n1;2;3";

		//when
		separateAPI.findCustomSeparator(sentence);

		//then
		assertThrows(IndexOutOfBoundsException.class,
				() -> separator.getSeparators(2));
	}

	@Test
	@DisplayName("커스텀 구분자가 없을 경우")
	void isExitCustomSeparator() {
		//given
		String sentence = "//\n1;2;3";

		//when
		separateAPI.findCustomSeparator(sentence);

		//then
		assertThrows(IndexOutOfBoundsException.class,
				() -> separator.getSeparators(2));
	}

	@Test
	@DisplayName("숫자 추출 기능 테스트")
	void findNumberAndSave() {
		//given
		String sentence = "13:235:33";

		//when
		separateAPI.findNumberAndSave(sentence);
		int answer = calculatorAPI.answer();

		//then
		assertEquals(281, answer);
	}

}