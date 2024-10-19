package calculator.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {

    @Test
    @DisplayName("파라미터가 숫자가 아니면 에러를 던진다")
    void testIsNotNumber() {
        // when, then
        assertThatThrownBy(() -> NumberValidator.isNotNumber(":"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력값입니다.");

        assertThatThrownBy(() -> NumberValidator.isNotNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력값입니다.");
    }
}
