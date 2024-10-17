package calculator;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {

	Calculator calculator;

	@BeforeEach
	void setup() {
		calculator = new Calculator();
	}

	@ParameterizedTest
	@MethodSource("provide_input_for_test_sum_validation")
	void test_sum_validation(String input) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.sum(input));
	}

	static Stream<Arguments> provide_input_for_test_sum_validation() {
		return Stream.of(
			Arguments.of("//1,2,3,4,5\\n123"),
			Arguments.of("//1,2,3,4,5\\n"),  // 숫자 부분이 비어있음
			Arguments.of("//\\n"),           // 구분자와 숫자 부분이 모두 비어있음
			Arguments.of("//;\\n"),          // 숫자 부분이 비어있음
			Arguments.of("//"),              // 잘못된 형식
			Arguments.of("-1,2,3"),          // 음수 포함
			Arguments.of("1,-2,3"),          // 음수 포함
			Arguments.of("1,2,a")           // 숫자가 아닌 값 포함
		);
	}

	@ParameterizedTest
	@MethodSource("provide_input_for_test_sum")
	void test_sum(String input, int expected) {
		Assertions.assertEquals(expected, calculator.sum(input));
	}

	static Stream<Arguments> provide_input_for_test_sum() {
		return Stream.of(Arguments.of("1", 1), Arguments.of("1,2,3", 6), Arguments.of("5,6,7,2", 20),
			Arguments.of("1:2", 3), Arguments.of("1:2:4", 7), Arguments.of("//a\\n1", 1),
			Arguments.of("//;\\n1:2,4;5", 12), Arguments.of("//,\\n5:7,2", 14),
			Arguments.of("//[!!\\n5[!!6[!!7[!!2", 20),Arguments.of("//;\\n1:2,4;5"));
	}

}
