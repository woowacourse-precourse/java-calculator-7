package calculator.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {

	@DisplayName("계산기는 올바른 입력 값에 대해 덧셈을 할 수 있다")
	@ParameterizedTest
	@MethodSource("equationAndCorrectResult")
	void validateCalculator(String validData, Long correctResult) {
		assertThat(Calculator.from(validData).sum()).isEqualTo(correctResult);
	}

	static Stream<Arguments> equationAndCorrectResult() {
		return Stream.of(
			Arguments.of("", 0L),
			Arguments.of("1,2:3", 6L),
			Arguments.of("1000000000,2000000000:3000000000", 6000000000L),
			Arguments.of("//#\\n1#2,3#7", 13L),
			Arguments.of("//a\\n1a2,3a7", 13L),
			Arguments.of("//~\\n1~2,3~7", 13L)
		);
	}
}