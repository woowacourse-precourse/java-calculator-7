package calculator.domain;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @MethodSource("testData")
    @ParameterizedTest
    void 더하기_계산(String[] input, int output) {
        Numbers numbers = new Numbers(input);
        assertThat(new Calculator().calculate(numbers)).isEqualTo(output);
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.arguments(new String[]{"1", "2", "3"}, 6),
                Arguments.arguments(new String[]{"230123", "328220", "233272"}, 791615),
                Arguments.arguments(new String[]{}, 0)
        );
    }
}
