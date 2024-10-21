package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CalculatorTest {
    @ParameterizedTest
    @DisplayName("빈 문자열 또는 null 값 입력시 0 출력 테스트")
    @NullAndEmptySource
    void null_또는_빈문자(String text) {
        int result = Calculator.calculate(text);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환 테스트")
    void 숫자_하나_입력_테스트() {
        int result = Calculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 합 구하는 기능 테스트")
    void 더하기_기능_테스트() {
        int result = Calculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자 콜론 테스트")
    void 구분자_콜론_테스트() {
        int result = Calculator.calculate("1:2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("음수 예외처리 테스트")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> Calculator.calculate("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 이외의 값 예외 처리 테스트")
    public void NonNumeric_values() throws Exception {
        assertThatThrownBy(() -> Calculator.calculate("asd"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
