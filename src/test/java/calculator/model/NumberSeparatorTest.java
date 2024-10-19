package calculator.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberSeparatorTest {

	@DisplayName("분리기는 숫자를 분리한다")
	@ParameterizedTest
	@ValueSource(strings = {"1,2:3", "4:5:6,7", "3,4", "//!\\n3!2,3"})
	void validateSeparateNumber(String validData) {
		assertDoesNotThrow(() -> NumberSeparator.from(validData).separate());
	}

	@DisplayName("분리기의 커스텀 구분자에 숫자, 공백, 길이가 2 이상인 문자열이 올 수 없다")
	@ParameterizedTest
	@ValueSource(strings = {"//3\\n", "//\\n", "//!@\\n", "//ab\\n", "//\t\\n"})
	void validateSeparateNumberCharacter(String invalidData) {
		assertThrows(IllegalArgumentException.class, () -> NumberSeparator.from(invalidData).separate());
	}

	@DisplayName("분리기의 커스텀 구분자는 기본 구분자와 같을 수 없다")
	@ParameterizedTest
	@ValueSource(strings = {"//,\\n", "//:\\n"})
	void validateSeparateNumberDefault(String invalidData) {
		assertThrows(IllegalArgumentException.class, () -> NumberSeparator.from(invalidData).separate());
	}

	@DisplayName("숫자 사이의 공백은 허용하지 않는다")
	@ParameterizedTest
	@ValueSource(strings = {"1 2:3,4", "34\t2:2"})
	void validateSeparateNumberSpace(String invalidData) {
		assertThrows(IllegalArgumentException.class, () -> NumberSeparator.from(invalidData).separate());
	}

	@DisplayName("분리기의 커스텀 구분자는 입력 문자열 맨 앞에 있어야 한다")
	@ParameterizedTest
	@ValueSource(strings = {"1:2!3,4//!\\n", "1:2//!\\n!3", "1//!\\n!3!4"})
	void validateSeparateNumberPosition(String invalidData) {
		assertThrows(IllegalArgumentException.class, () -> NumberSeparator.from(invalidData).separate());
	}
}