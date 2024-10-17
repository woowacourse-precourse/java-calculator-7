package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    static final int MAX_NUMBER_DIGITS = 30;

    @Test
    @DisplayName("0과 0을 더하면 0이여야 한다.")
    void plusZeroAndZeroTest() {
        // given
        Number zero1 = Number.ofZero();
        Number zero2 = Number.ofZero();

        // when
        Number sum = zero1.plus(zero2);

        // then
        assertThat(sum).isEqualTo(Number.ofZero());
    }

    @Test
    @DisplayName("0과 0이 아닌 숫자를 더하면 변화가 없어야 한다.")
    void plusNumberAndZeroTest() {
        // given
        Number zero = Number.ofZero();
        Number number = Number.of("100");

        // when
        Number sum = zero.plus(number);

        // then
        assertThat(sum).isEqualTo(number);
    }

    @Test
    @DisplayName("아무런 숫자가 없다면 0을 반환해야 한다.")
    void emptyNumberZeroTest() {
        // given
        Numbers numbers = Numbers.of(new ArrayList<>());

        // when
        Number sum = Calculator.calculateSum(numbers);

        // then
        assertThat(sum).isEqualTo(Number.ofZero());
    }

    @Test
    @DisplayName("여러 개의 숫자가 있다면 숫자들의 합을 반환해야 한다.")
    void calculateSumTest() {
        // given
        Number firstNumber = Number.of("1");
        Number secondNumber = Number.of("999");
        Numbers numbers = Numbers.of(List.of(firstNumber, secondNumber));

        // when
        Number sum = Calculator.calculateSum(numbers);

        // then
        assertThat(sum).isEqualTo(Number.of("1000"));
    }

    @Test
    @DisplayName("숫자의 합이 최대 자릿수를 초과하면 예외가 발생해야 한다.")
    void outOfMaxDigitsSumExceptionTest() {
        // given
        Number firstNumber = Number.of("1");
        Number secondNumber = Number.of("9".repeat(MAX_NUMBER_DIGITS));
        Numbers numbers = Numbers.of(List.of(firstNumber, secondNumber));

        // when, then
        assertThatThrownBy(() -> Calculator.calculateSum(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
