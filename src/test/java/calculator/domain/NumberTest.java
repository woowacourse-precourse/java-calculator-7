package calculator.domain;

import calculator.domain.value.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {
    @Test
    @DisplayName("올바른 숫자를 생성한다.")
    void 올바른_숫자_생성() {
        // Given
        String input = "5";

        // When
        Number number = new Number(input);

        // Then
        assertThat(number.getValue()).isEqualTo(5);
    }

    @Test
    @DisplayName("음수를 입력하면 예외를 발생시킨다.")
    void 음수_입력_예외() {
        // Given
        String negativeInput = "-1";

        // When, Then
        assertThatThrownBy(() -> new Number(negativeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 허용되지 않습니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 문자를 입력하면 예외를 발생시킨다.")
    void 문자_입력_예외() {
        // Given
        String invalidInput = "a";

        // When, Then
        assertThatThrownBy(() -> new Number(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값이 포함되어 있습니다.");
    }
}
