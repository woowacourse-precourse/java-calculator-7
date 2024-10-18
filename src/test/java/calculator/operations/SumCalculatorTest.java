package calculator.operations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.exception.IllegalArgumentExceptionEnum;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SumCalculatorTest {

    @Test
    @DisplayName("정수 리스트의 합계 계산 성공")
    void sumWithValidIntegers() {
        int result = SumCalculator.sum(new ArrayList<>(List.of(1, 2, 3)));

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("오버플로우 발생 시 예외 처리")
    void sumWithOverflowThrowsException() {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(Integer.MAX_VALUE, 1));

        assertThatThrownBy(() -> SumCalculator.sum(numbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionEnum.ADDITION_OVERFLOW.getMessage());
    }
}
