package calculator.model;

import calculator.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumbersTest {
    @Test
    @DisplayName("음수인 경우, 예외가 발생한다.")
    public void validatePositive() {
        // given
        List<Integer> numbers = List.of(-1, 1, 2);

        // when & then
        assertThatThrownBy(() -> new PositiveNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ONLY_ALLOWED_POSITIVE_NUMBER);
    }
}
