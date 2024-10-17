package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateSum(strings));

        //then
        assertEquals("입력값 중 숫자는 0보다 커야합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("분리된 입력값 중 문자열이 존재할 경우 예외 발생")
    void validateNumericContent() {
        //given
        Calculator calculator = new Calculator();
        String[] strings = {"10", "20", "a"};

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateSum(strings));

        //then
        assertEquals("분리된 입력값에 문자열이 존재합니다.", exception.getMessage());
    }
}