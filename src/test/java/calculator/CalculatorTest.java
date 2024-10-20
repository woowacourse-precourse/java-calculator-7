package calculator;

import calculator.exception.InputValidationException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {
    @Test
    void 공백_예외_테스트() {
        assertThatThrownBy(() -> {
            InputValidationException.isEmpty("");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("아무것도 입력하지 않았습니다. 애플리케이션을 종료합니다.");
    }

    @Test
    void null_예외_테스트() {
        assertThatThrownBy(() -> {
            InputValidationException.isEmpty(null);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("아무것도 입력하지 않았습니다. 애플리케이션을 종료합니다.");
    }
}
