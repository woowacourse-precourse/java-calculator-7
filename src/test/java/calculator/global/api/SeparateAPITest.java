package calculator.global.api;

import calculator.domain.Separator;
import calculator.global.config.APIFactory;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparateAPITest {
	private final APIFactory apiFactory = APIFactory.getInstance();
	private final Separator separator = Separator.getInstance();

	@Test
	@DisplayName("커스텀 구분자가 있을 경우")
	void findCustomSeparator() {
		//given
		String sentence = "//;\n1;2;3";

		//when
		apiFactory.separate().findCustomSeparator(sentence);
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
		apiFactory.separate().findCustomSeparator(sentence);

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
		apiFactory.separate().findCustomSeparator(sentence);

		//then
		assertThrows(IndexOutOfBoundsException.class,
				() -> separator.getSeparators(2));
	}

	@Test
	void findNumberAndSave() {
	}

}