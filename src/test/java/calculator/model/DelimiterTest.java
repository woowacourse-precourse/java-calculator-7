package calculator.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

	@DisplayName("구분자는 길이가 1이어야 한다")
	@ParameterizedTest
	@EmptySource
	@ValueSource(strings = {"chihyun", "ch", "", " ", "\n", "\t"})
	void validateLength(String invalidData) {
		assertThrows(IllegalArgumentException.class, () -> Delimiter.from(invalidData));
	}
}