package calculator.model;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {

    @ParameterizedTest(name = "숫자 : {0}, 합 : {1}")
    @DisplayName("숫자들에 대한 덧셈을 진행한다.")
    @MethodSource("addedNumbersAndSum")
    void add(List<Integer> numbers, int sum) {
        Calculator calculator = new Calculator();
        int result = calculator.add(numbers);
        Assertions.assertThat(result).isEqualTo(sum);
    }

    private static Stream<Arguments> addedNumbersAndSum() {
        return Stream.of(
                Arguments.of(List.of(), 0),
                Arguments.of(List.of(1), 1),
                Arguments.of(List.of(1, 2, 3, 4), 10)
        );
    }
}