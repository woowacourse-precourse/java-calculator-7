package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    void 양수_입력_테스트() {
        InputValidator.validateNumber("10");
        InputValidator.validateNumber("0");
    }

    @Test
    void 음수_입력_예외_테스트() {
        assertThatThrownBy(() -> InputValidator.validateNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 허용되지 않습니다: -1");
    }

    @Test
    void 숫자가_아닌_문자열_예외_테스트() {
        assertThatThrownBy(() -> InputValidator.validateNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 형식이 아닙니다: a");
    }
}