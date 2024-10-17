package calculator.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DelimiterTest {

	@DisplayName("구분자는 길이가 1이어야 한다")
	@ParameterizedTest
	@MethodSource("blankOrLengthOver1Delimiter")
	void validateLength(String invalidData) {
		assertThrows(IllegalArgumentException.class, () -> Delimiter.from(invalidData));
	}

	static Stream<Arguments> blankOrLengthOver1Delimiter() {
		return Stream.of(
			Arguments.of(""),
			Arguments.of(" "),
			Arguments.of("gd")
		);
	}
}