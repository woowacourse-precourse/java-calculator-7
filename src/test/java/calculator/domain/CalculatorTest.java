package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("리스트에 들어있는 숫자의 합을 구할 수 있다.")
    @Test
    void sumNumbers() {
        //given
        List<Integer> numbers = List.of(10, 45, 55);
        //when
        int sum = calculator.sumNumbers(numbers);
        //then
        assertThat(sum).isEqualTo(110);
    }

    @DisplayName("리스트에 들어있는 숫자중 0 또는 음수가 있으면 예외가 발생한다. ")
    @ParameterizedTest
    @MethodSource("provideInvalidNumberLists")
    void throwsExceptionWhenNumberIsMinus(List<Integer> numbers) {
        //given
        //when
        //then
        assertThatThrownBy(() -> calculator.sumNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수로 구성된 문자열만 입력 가능 합니다.");
    }

    private static Stream<List<Integer>> provideInvalidNumberLists() {
        return Stream.of(
                List.of(-1, 44, 55),
                List.of(0, 1, 2),
                List.of(-11, 0, 55)
        );
    }
}