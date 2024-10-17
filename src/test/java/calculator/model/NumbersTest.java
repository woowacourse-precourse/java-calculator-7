package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NumbersTest {

	@DisplayName("숫자는 양수이어야 한다.")
	@ParameterizedTest
	@MethodSource("negativeOrZeroNumbers")
	void validatePositive(List<Integer> invalidData) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> Numbers.from(invalidData));
	}

	static Stream<Arguments> negativeOrZeroNumbers() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, -3)),
			Arguments.of(Arrays.asList(1, 0))
		);
	}
}
