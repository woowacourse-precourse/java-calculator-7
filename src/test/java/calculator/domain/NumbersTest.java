package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NumbersTest {

    @MethodSource("testData")
    @ParameterizedTest
    void 숫자_저장_성공(String[] input, List<Integer> output) {
        Numbers numbers = new Numbers(input);
        assertThat(numbers.getNumbers()).isEqualTo(output);
    }

    @MethodSource("errorTestData")
    @ParameterizedTest
    void 숫자_저장_실패(String[] input, Exception e) {
        assertThatThrownBy(() -> new Numbers(input)).isInstanceOf(e.getClass());
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.arguments(new String[] {"1", "2", "3"}, List.of(1, 2, 3)),
                Arguments.arguments(new String[] {"230123", "328220", "233272"}, List.of(230123, 328220, 233272)),
                Arguments.arguments(new String[] {""}, List.of(0))
        );
    }

    static Stream<Arguments> errorTestData() {
        return Stream.of(
                Arguments.arguments(new String[] {"a", "2", "3"}, new IllegalArgumentException()),
                Arguments.arguments(new String[] {"-1", "328220", "233272"}, new IllegalArgumentException())
        );
    }
}
