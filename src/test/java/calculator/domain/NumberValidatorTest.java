package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {

    @Test
    @DisplayName("음수가 있을 경우 예외 발생")
    void 숫자_양수_검사() {
        // given
        List<Integer> numbers = List.of(-1, 2, 3, 4);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            NumberValidator.isPositiveNumber(numbers);
        });
    }
}