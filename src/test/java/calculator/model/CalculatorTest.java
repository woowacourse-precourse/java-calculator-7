package calculator.model;

import calculator.controller.CalculatorController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("덧셈 확인")
class CalculatorTest {
    @ParameterizedTest(name = "{index} : {2}")
    @DisplayName("덧셈 확인")
    @MethodSource("generateData")
    void testSum(String input, int output, String message) {
        Numbers numbers = new Numbers(new CalculatorController().getNumbers(input));
        assertThat(new Calculator().calculateSum(numbers)).isEqualTo(output);
    } // testSum

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("//!@\\n1!2@3", 6, "커스텀 구분자 사용"),
                Arguments.of("1,2:3", 6, "기본 구분자 사용"),
                Arguments.of("123", 123, "구분자 사용하지 않음")
        );
    } // generateData
} // class