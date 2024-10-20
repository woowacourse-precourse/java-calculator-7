package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NumbersTest {

    static Stream<Arguments> createWrongNumbers() {
        return Stream.of(
                Arguments.arguments(Arrays.asList(1, 0, 2, 3))
        );
    }

    static Stream<Arguments> createPositiveNumbers() {
        return Stream.of(
                Arguments.arguments(Arrays.asList(1, 8, 2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("createWrongNumbers")
    @DisplayName("입력한 숫자들에 음수 혹은 0이 포함되면 예외")
    void throws_when_contains_none_positive(List<Integer> numbers) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Numbers(numbers));
    }

    @ParameterizedTest
    @MethodSource("createPositiveNumbers")
    @DisplayName("리스트에 담긴 숫자들의 합을 정상적으로 구한다")
    void run_when_contains_numbers(List<Integer> numbers) {
        Assertions.assertEquals(new Numbers(numbers).getSummary(), 14);
    }
}
