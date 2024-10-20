package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.parser.InputParser;
import calculator.validation.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @DisplayName("문자열 덧셈 계산 테스트")
    @ParameterizedTest
    @MethodSource("calculateData")
    void add(String text, int expected) {
        int result = calculatorService.add(text);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> calculateData() {
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("1:2:3", 6),
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//|\n1|2|3", 6),
                Arguments.of("//|\n5|5|5", 15)
        );
    }
}
