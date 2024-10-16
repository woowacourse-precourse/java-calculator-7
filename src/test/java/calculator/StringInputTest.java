package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringInputTest {

    @Test
    @DisplayName("빈 문자열 입력 시 0 반환")
    void 빈_문자열_입력() {
        String input = "";

        int result = Calculator.performAddition(input);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("지정 구분자를 혼합해서 사용해도 정상적으로 동작해야 한다")
    void 지정구분자_혼합사용() {
        String input = "1:2,3:4,5";

        int result = Calculator.performAddition(input);

        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("지정 구분자와 커스텀 구분자를 혼합해서 사용해도 정상적으로 동작해야 한다")
    void 지정구분자_커스텀구분자_혼합사용() {
        String input = "//;\\n1;2,3:4,5";

        int result = Calculator.performAddition(input);

        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("음수 입력시 IllegalArgumentException 발생")
    void 음수_입력시_예외_발생() {
        String input = "1,-1,2";

        assertThrows(IllegalArgumentException.class, () -> {
            int result = Calculator.performAddition(input);
        });
    }

    @Test
    @DisplayName("구분자 없이 문자열을 입력하면 IllegalArgumentException 발생")
    void 구분자_없으면_예외_발생() {
        String input = "123";

        assertThrows(IllegalArgumentException.class, () -> {
            int result = Calculator.performAddition(input);
        });
    }

    @Test
    @DisplayName("문자열의 끝에 숫자가 아닌 구분자가 오는 경우 무시한다")
    void 문자열_끝에_구분자_입력() {
        String input = "1:2:3:";

        int result = Calculator.performAddition(input);

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열에 구분자가 2개 연속으로 입력되면 IllegalArgumentException 발생")
    void 구분자_연속으로_입력() {
        String input = "1:2::3:";

        assertThrows(IllegalArgumentException.class, () -> {
            int result = Calculator.performAddition(input);
        });
    }

    @Test
    @DisplayName("지정된 구분자 이외의 문자열이 입력되면 IllegalArgumentException 발생")
    void 지정구분자_이외의_문자_입력() {
        String input = "1,2a3";

        assertThrows(IllegalArgumentException.class, () -> {
            int result = Calculator.performAddition(input);
        });
    }

    @Test
    @DisplayName("\\n이 문자열에서 두번 등장하는 경우 IllegalArgumentException 발생")
    void 커스텀구분자_지정_문자열_두번_등장() {
        String input = "//;\\n1;2,3:4\\n5";

        assertThrows(IllegalArgumentException.class, () -> {
            int result = Calculator.performAddition(input);
        });
    }
}
