package calculator.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

	@DisplayName("구분자는 길이가 1이어야 한다")
	@ParameterizedTest
	@EmptySource
	@ValueSource(strings = {"chihyun", "ch", "", " ", "\n", "\t"})
	void isLength1(String invalidData) {
		assertThrows(IllegalArgumentException.class, () -> Delimiter.from(invalidData));
	}

	@DisplayName("구분자는 숫자가 될 수 없다")
	@ParameterizedTest
	@ValueSource(strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"})
	void isNotNumber(String invalidData) {
		assertThrows(IllegalArgumentException.class, () -> Delimiter.from(invalidData));
	}
}