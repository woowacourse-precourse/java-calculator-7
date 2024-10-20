package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @DisplayName("리스트에 들어있는 숫자의 합을 구할 수 있다. ")
    @Test
    void sumNumbers() {
        //given
        Calculator calculator = new Calculator();
        List<Integer> numbers = asList(10, 45, 55);
        //when
        int sum = calculator.sumNumbers(numbers);
        //then
        assertThat(sum).isEqualTo(110);
    }

    @DisplayName("리스트에 들어있는 숫자중 음수가 있으면 예외가 발생한다. ")
    @Test
    void throwsExceptionWhenNumberIsMinus() {
        //given
        Calculator calculator = new Calculator();
        List<Integer> numbers = asList(-1, 45, 55);
        //when
        //then
        assertThatThrownBy(() -> calculator.sumNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수로 구성된 문자열만 입력 가능 합니다.");
    }
}