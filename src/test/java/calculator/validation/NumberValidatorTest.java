package calculator.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {

    @Test
    @DisplayName("숫자가 아니거나 음수일 때 에러를 던진다.")
    void testIsNotNumberOrNotPositive() {
        // when, then
        assertThatThrownBy(() -> NumberValidator.isNotNumberOrNotPositive(":"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력값입니다.");

        assertThatThrownBy(() -> NumberValidator.isNotNumberOrNotPositive(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력값입니다.");
    }
}
