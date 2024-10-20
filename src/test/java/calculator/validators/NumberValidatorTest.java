package calculator.validators;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    @Test
    @DisplayName("numberValidate - 음수가 있는 경우 예외가 발생해야한다.")
    void negative() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, -4);
        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumberValidator.numberValidate(numbers));
    }

    @Test
    @DisplayName("numberValidate - 모두 양수인 경우 정상 동작한다.")
    void positive() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4);
        // when & then
        assertDoesNotThrow(() -> NumberValidator.numberValidate(numbers));
    }

}