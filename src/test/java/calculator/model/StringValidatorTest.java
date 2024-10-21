package calculator.model;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringValidatorTest {

	@ParameterizedTest
	@DisplayName("기본 문자열이 입력되었을 때 에러 없이 이를 검증한다.")
	@ValueSource(strings = {"1,2:3", "1,2,3", "1:2:3"})
	void 기본_문자열이_입력되었을_때_검증한다(String input) {
		// given
		StringValidator stringValidator = new StringValidator(input);

		// when, then
		assertThatCode(stringValidator::validate).doesNotThrowAnyException();
	}
}