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

    static Stream<Arguments> createNumbers() {
        return Stream.of(
                Arguments.arguments(Arrays.asList(1, 0, 2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("createNumbers")
    @DisplayName("입력한 숫자들에 음수 혹은 0이 포함되면 예외")
    void throws_when_contains_none_positive(List<Integer> numbers) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Numbers(numbers));
    }
}
