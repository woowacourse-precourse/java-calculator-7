package calculator.model;

import calculator.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumbersTest {
    @Test
    @DisplayName("양수가 아닌 경우, 예외가 발생한다.")
    public void validatePositive() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(0, 1, 2));

        // when & then
        assertThatThrownBy(() -> new PositiveNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ONLY_ALLOWED_POSITIVE_NUMBER);
    }
}
