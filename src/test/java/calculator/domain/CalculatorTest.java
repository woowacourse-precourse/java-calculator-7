package calculator.domain;

import calculator.exception.NonPositiveNumberException;
import calculator.exception.StringInSplittedInputException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CalculatorTest {
    @Test
    @DisplayName("분리된 입력값의 합을 계산")
    void calculateSum() {
        //given
        Calculator calculator = new Calculator();
        String[] strings = {"10", "20", "30"};

        //when
        int sum = calculator.calculateSum(strings);

        //then
        Assertions.assertThat(sum).isEqualTo(60);
    }

    @Test
    @DisplayName("분리된 입력값 중 음수가 존재할 경우 예외 발생")
    void validateNoNegativeNumber() {
        //given
        Calculator calculator = new Calculator();
        String[] strings = {"10", "-20", "30"};

        //then
        Assertions.assertThatThrownBy(() ->
                calculator.calculateSum(strings)).isInstanceOf(NonPositiveNumberException.class);
    }

    @Test
    @DisplayName("분리된 입력값 중 문자열이 존재할 경우 예외 발생")
    void validateNumericContent() {
        //given
        Calculator calculator = new Calculator();
        String[] strings = {"10", "20", "a"};

        //then
        Assertions.assertThatThrownBy(() ->
                calculator.calculateSum(strings)).isInstanceOf(StringInSplittedInputException.class);
    }
}