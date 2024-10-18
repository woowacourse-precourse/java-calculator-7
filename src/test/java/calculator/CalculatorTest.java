package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void 빈_문자열_또는_null_입력_0_반환() {
        assertThat(calculator.splitAndSum("")).isZero();
        assertThat(calculator.splitAndSum(null)).isZero();
    }

    @Test
    void 기본_구분자_사용() {
        assertThat(calculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_사용() {
        assertThat(calculator.splitAndSum("//;\\n1;2;3")).isEqualTo(6);
        assertThat(calculator.splitAndSum("//.\\n1.2.3")).isEqualTo(6);
        assertThat(calculator.splitAndSum("//;\\n1;2,3:4")).isEqualTo(10);
    }

    @Test
    void 여러_개의_커스텀_구분자_예외_테스트() {
        assertThatThrownBy(() -> calculator.splitAndSum("//;[]\\n1;[]2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 커스텀 구분자입니다. 구분자는 단일 문자여야 합니다. 문제가 되는 입력값: [;[]]");
    }

    @Test
    void 음수_입력_예외_테스트() {
        assertThatThrownBy(() -> calculator.splitAndSum("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자와 양수만 입력 가능합니다. 문제가 되는 입력값: [-2]");
    }

    @Test
    void zero_입력_예외_테스트() {
        assertThatThrownBy(() -> calculator.splitAndSum("1,0,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자와 양수만 입력 가능합니다. 문제가 되는 입력값: [0]");
    }

    @Test
    void 계산_결과_오버플로우_예외_테스트() {
        assertThatThrownBy(() -> calculator.splitAndSum("2147483647,1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값의 계산 결과가 정수 범위를 초과했습니다.");
    }
}
