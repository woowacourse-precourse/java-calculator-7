package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

    private Numbers numbers;

    @BeforeEach
    void setUp() {
        numbers = new Numbers();
    }

    @DisplayName("사용자 입력 값이 음수일 경우 예외가 발생한다.")
    @Test
    void 사용자_입력_음수_실패() {
        String[] input = {"-1", "2", "3"};

        assertThatThrownBy(() -> numbers.parseToIntArray(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 입력 값이 0일 경우 예외가 발생한다.")
    @Test
    void 사용자_입력_0_실패() {
        String[] input = {"0", "2", "3"};

        assertThatThrownBy(() -> numbers.parseToIntArray(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 입력 값이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 사용자_입력_숫자_아닐때_실패() {
        String[] input = {"a", "2", "3"};

        assertThatThrownBy(() -> numbers.parseToIntArray(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}