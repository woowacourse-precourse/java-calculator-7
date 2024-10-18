package calculator.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberSeparatorTest {

	@DisplayName("분리기는 숫자를 분리한다")
	@ParameterizedTest
	@ValueSource(strings = {"1,2:3", "4:5:6,7", ":,:3,,4", "//!\\n3:!!2,3"})
	void validateSeparateNumber(String validData) {
		assertDoesNotThrow(() -> NumberSeparator.from(validData).separate());
	}

	@DisplayName("분리기의 커스텀 구분자에 숫자, 공백, 길이가 2 이상인 문자열이 올 수 없다")
	@ParameterizedTest
	@ValueSource(strings = {"//3\\n", "//\\n", "//!@\\n", "//ab\\n"})
	void validateSeparateNumberCharacter(String invalidData) {
		assertThrows(IllegalArgumentException.class, () -> NumberSeparator.from(invalidData).separate());
	}
}