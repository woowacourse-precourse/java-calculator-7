package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    void 빈_입력_검증() {
        assertThatThrownBy(() -> new Calculator(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백을 입력할 수 없습니다.");
    }

    @Test
    void 구분자로_끝나는_입력_검증() {
        assertThatThrownBy(() -> new Calculator("1,2:3,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자로 끝날 수 없습니다.");
    }

    @Test
    void 구분자로_시작하는_입력_검증() {
        assertThatThrownBy(() -> new Calculator(",1:2:3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자로 시작할 수 없습니다.");
    }

    @Test
    void 유효하지_않은_구분자_검증() {
        assertThatThrownBy(() -> new Calculator("1,2:3,-4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 구분자입니다.");
    }

    @Test
    void 음수_입력_검증() {
        assertThatThrownBy(() -> new Calculator("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 구분자입니다.");
    }

}
