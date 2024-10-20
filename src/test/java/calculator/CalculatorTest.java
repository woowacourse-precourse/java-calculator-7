package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @DisplayName("계산기가 문자열을 입력받고 계산이 성공적으로 이루어지는지 테스트합니다.")
    @ParameterizedTest
    @MethodSource("calculateData")
    void calculate(String inputStr, int expectedResult) {
        int result = calculator.calculate(inputStr);
        assertThat(result).isEqualTo(expectedResult);
    }

    static Stream<Arguments> calculateData() {
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("1:2:3", 6),
                Arguments.of("//;\\n1;2;3", 6),
                Arguments.of("//\\.\\n1.2.3", 6),
                Arguments.of("//\\.\\n5.10.15", 30)
        );
    }
}