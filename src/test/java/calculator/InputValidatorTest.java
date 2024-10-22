package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("음수가 포함되었는지 검증하는 메서드를 테스트하라")
    @Test
    void test_validateNumbers() {
        List<Integer> numbers = List.of(-1, 1, 2, -3);

        assertThatThrownBy(() ->
                InputValidator.validateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 허용되지 않습니다: [-1, -3]");

    }
}
