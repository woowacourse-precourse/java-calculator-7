package calculator.parser;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

	Parser parser = new Parser();

	@DisplayName("여러 성공 시나리오의 값이 예외없이 성공하는지 확인한다.")
	@ParameterizedTest
	@ValueSource(strings = {"//;\\n1;2", "// \\n1 2,3:4", "1,2:3"})
	void 수식_파싱_성공(String input) {
		assertThatNoException().isThrownBy(() -> parser.parse(input));
	}

	@DisplayName("의도한 결과가 올바르게 나오는지 확인한다.")
	@Test
	void 수식_파싱_성공_올바른_값_리턴() {
		assertThat(parser.parse("//;\\n1,2;3:4,5"))
				.containsExactlyInAnyOrder(1, 2, 3, 4, 5);
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

	@ParameterizedTest
	@ValueSource(strings = {"//;\\n1;2", "1,2,3"})
	void 순수_식_만들기_성공(String input) {
		assertThatNoException().isThrownBy(() -> parser.parse(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"//;\\n;1;2;3", ",1,2,3"})
	void 순수_식_만들기_실패_숫자로_시작하지_않음(String input) {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> parser.parse(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"//;\\n1;2;3;", "1,2,3,"})
	void 순수_식_만들기_실패_숫자로_끝나지_않음(String input) {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> parser.parse(input));
	}

	@Test
	void 숫자_추출_실패_잘못된_구분자_포함() {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> parser.parse("//;\\n1;2,3:4.5"));
	}
}
