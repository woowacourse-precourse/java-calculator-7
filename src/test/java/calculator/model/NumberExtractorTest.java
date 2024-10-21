package calculator.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumberExtractorTest {

	@ParameterizedTest
	@DisplayName("올바른 구분자가 포함되면서 구분자와 수의 순서가 번갈아 나오는 올바른 문자열이 입력되었을 때 수의 리스트를 반환한다.")
	@MethodSource("유효한_문자열_예제_케이스")
	void 유효한_문자열이_입력되었을_때_수의_리스트를_반환한다(String input, List<Integer> expectedResult) {
		// given
		NumberExtractor numberExtractor = new NumberExtractor();

		// when
		List<Integer> result = numberExtractor.extractNumbers(input);

		// then
		assertEquals(expectedResult, result);
	}

	@ParameterizedTest
	@DisplayName("숫자가 한 자리 수가 아니라면 그 수의 길이만큼 수를 추출한 후 수의 리스트를 반환한다.")
	@MethodSource("N자리_수_예제_케이스")
	void N자리_수가_포함된_유효한_문자열이_입력되었을_때_수의_리스트를_반환한다(String input, List<Integer> expectedResult) {
		// given
		NumberExtractor numberExtractor = new NumberExtractor();

		// when
		List<Integer> result = numberExtractor.extractNumbers(input);

		// then
		assertEquals(expectedResult, result);
	}

	private static Stream<Arguments> 유효한_문자열_예제_케이스() {
		return Stream.of(
			    Arguments.of("1,2:3", List.of(1, 2, 3)),
			    Arguments.of("1:2,3#4", List.of(1, 2, 3, 4))
		);
	}

	private static Stream<Arguments> N자리_수_예제_케이스() {
		return Stream.of(
			Arguments.of("1,22:333", List.of(1, 22, 333)),
			Arguments.of("1:22,333#4444", List.of(1, 22, 333, 4444))
		);
	}
}