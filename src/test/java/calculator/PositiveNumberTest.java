package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PositiveNumberTest {

    @Test
    void 음수인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new PositiveNumber(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 음수는 입력할 수 없습니다.");
    }
}
