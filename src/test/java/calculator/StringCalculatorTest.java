package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @Test
    void 기본_구분자_테스트() {
        int result = StringCalculator.add("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_테스트() {
        int result = StringCalculator.add("//;\\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 빈_입력_테스트() {
        int result = StringCalculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자만_입력_테스트() {
        int result = StringCalculator.add("5");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 공백이_포함된_입력_테스트() {
        int result = StringCalculator.add("1, 2: 3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 음수_입력_시_예외_테스트() {
        assertThatThrownBy(() -> StringCalculator.add("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 허용되지 않습니다: -2");
    }

    @Test
    void 긴_숫자_입력_테스트() {
        int result = StringCalculator.add("2831,1000:839");
        assertThat(result).isEqualTo(4670);
    }

    @Test
    void 숫자_외_입력_시_예외_테스트() {
        assertThatThrownBy(() -> StringCalculator.add("1,a,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 형식이 아닙니다: a");
    }
}