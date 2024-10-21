package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;

class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();

    static Stream<Arguments> successfulInputs() {
        return Stream.of(
                Arguments.of("1,2:3", 6),
                Arguments.of("//;\\n1;2;3", 6),
                Arguments.of("//;\\n1;2,3:4;5", 15)
        );
    }

    @ParameterizedTest
    @MethodSource("successfulInputs")
    @DisplayName("기본 구분자, 커스텀 구분자, 혼합 구분자를 사용하여 계산에 성공한다.")
    void 계산_성공_기본_및_커스텀_구분자(String input, int expected) {
        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @EmptySource
    void 빈_문자열_처리(String input) {
        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isZero();
    }

}
