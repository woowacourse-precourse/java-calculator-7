package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    @DisplayName("기본 구분자를 기준으로 한 각 숫자들의 합 계산")
    void basic_separator() {
        assertThat(Calculator.calculate("1,2:3")).isEqualTo(6);
        assertThat(Calculator.calculate("1:2:3")).isEqualTo(6);
        assertThat(Calculator.calculate("1,2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 기준으로 한 각 숫자들의 합 계산")
    void custom_separator() {
        assertThat(Calculator.calculate("//;\\n1;2;3")).isEqualTo(6);
        assertThat(Calculator.calculate("// \\n1 2 3")).isEqualTo(6);
        assertThat(Calculator.calculate("///\\n1/2/3")).isEqualTo(6);
        assertThat(Calculator.calculate("//\\\\n1\\2\\3")).isEqualTo(6);
    }

    @Test
    @DisplayName("잘못된 입력시 IllegalArgumentException 예외")
    void when_input_is_wrong_then_throws_IllegalArgumentException() {
        assertThatThrownBy(() -> Calculator.calculate("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Calculator.calculate("a,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Calculator.calculate(",2,3"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Calculator.calculate("//;\\n-1;2;3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Calculator.calculate("//;\\n;1;2;3"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Calculator.calculate("/;\\n1;2;3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Calculator.calculate("//;\\1;2;3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}