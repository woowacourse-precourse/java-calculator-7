package calculator.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NumbersTest {

	@DisplayName("숫자는 양수이어야 한다")
	@ParameterizedTest
	@MethodSource("negativeOrZeroNumbers")
	void validatePositive(List<Long> invalidData) {
		assertThrows(IllegalArgumentException.class, () -> Numbers.from(invalidData));
	}

	@DisplayName("숫자의 합을 계산할 수 있다")
	@ParameterizedTest
	@MethodSource("numbersAndCorrectResult")
	void validateSum(List<Long> validData, Long correctResult) {
		Numbers numbers = Numbers.from(validData);
		assertThat(numbers.sum()).isEqualTo(correctResult);
	}

	@DisplayName("숫자는 문자열 배열을 변환할 때 문자열에 문자가 포함되어 있으면 예외를 반환한다")
	@ParameterizedTest
	@MethodSource("stringIncludeCharacter")
	void validateParseNumbersCharacter(List<String> invalidData) {
		assertThrows(IllegalArgumentException.class, () -> Numbers.parseNumbers(invalidData));
	}

	@DisplayName("숫자는 문자열 배열을 변환할 때 표현 범위를 넘어서면 예외를 반환한다")
	@ParameterizedTest
	@MethodSource("stringNumberOverRange")
	void validateParseNumbersRange(List<String> invalidData) {
		assertThrows(IllegalArgumentException.class, () -> Numbers.parseNumbers(invalidData));
	}

	@DisplayName("숫자는 문자열 배열을 변환할 때 빈 문자열일 경우 건너뛴다")
	@ParameterizedTest
	@MethodSource("emptyStringNumber")
	void validateParseNumbersEmpty(List<String> validData) {
		assertDoesNotThrow(() -> Numbers.parseNumbers(validData));
	}

	static Stream<Arguments> numbersAndCorrectResult() {
		return Stream.of(
			Arguments.of(Arrays.asList(1L, 2L, 3L), 6L),
			Arguments.of(Arrays.asList(1000000000L, 2000000000L, 3000000000L), 6000000000L)
		);
	}

	static Stream<Arguments> negativeOrZeroNumbers() {
		return Stream.of(
			Arguments.of(Arrays.asList(1L, 2L, -3L)),
			Arguments.of(Arrays.asList(1L, 0L))
		);
	}

	static Stream<Arguments> stringIncludeCharacter() {
		return Stream.of(
			Arguments.of(Arrays.asList("1", "2", "5f5")),
			Arguments.of(Arrays.asList("1", "2", "55", "1!")),
			Arguments.of(Arrays.asList("!", "2", "55", "1")),
			Arguments.of(Arrays.asList("z", "55", "1"))
		);
	}

	static Stream<Arguments> stringNumberOverRange() {
		return Stream.of(
			Arguments.of(List.of("9223372036854775808"))
		);
	}

	static Stream<Arguments> emptyStringNumber() {
		return Stream.of(
			Arguments.of(List.of("")),
			Arguments.of(List.of(" ")),
			Arguments.of(List.of("\t")),
			Arguments.of(List.of("\n")),
			Arguments.of(List.of("   54  "))
		);
	}
}
