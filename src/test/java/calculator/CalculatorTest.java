package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {
    @DisplayName("숫자 리스트 덧셈")
    @ParameterizedTest(name = "{displayName}: {0}")
    @MethodSource("numbers")
    void addAllNumbers(List<Integer> input, Integer expected) {
        Calculator calculator = new Calculator();
        Integer sum = calculator.addAll(input);
        assertEquals(expected, sum);
    }

    static Stream<Arguments> numbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 6),
                Arguments.of(List.of(123), 123),
                Arguments.of(List.of(15, 26, 37), 78)
        );
    }

    @DisplayName("숫자 리스트에 음수 포함시 예외")
    @Test
    void checkInvalidNumbers() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.addAll(List.of(1, -2, 3)));
    }

}