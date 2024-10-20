package calculator.parser;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

	Parser parser = new Parser();

	@Test
	void 커스텀_구분자_추출_성공() {
		assertThatNoException().isThrownBy(() -> parser.parse("//;\n1;2"));
	}

	@ParameterizedTest
	@ValueSource(strings = {"/;\\n1;2", ";\\n1;2", "..;\\n1;2"})
	void 커스텀_구분자_추출_실패_접두사_오류(String input) {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> parser.parse(input))
				.withMessage("커스텀 구분자 지정은 //로 시작해야 합니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"//;;\\n1;2", "//\\n1,2"})
	void 커스텀_구분자_추출_실패_한글자가_아닌_구분자(String input) {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> parser.parse(input))
				.withMessage("커스텀 구분자 지정은 //와 \\n 사이에 하나의 문자를 작성해주세요.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"//;n1;2", "//;\\1;2"})
	void 커스텀_구분자_추출_실패_접미사_오류(String input) {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> parser.parse(input))
				.withMessage("커스텀 구분자 지정은 //와 \\n 사이에 하나의 문자를 작성해주세요.");
	}

	@Test
	void 커스텀_구분자_추출_실패_숫자구분자() {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> parser.parse("//3\\n132"))
				.withMessage("커스텀 구분자는 숫자는 불가능합니다.");
	}
}
