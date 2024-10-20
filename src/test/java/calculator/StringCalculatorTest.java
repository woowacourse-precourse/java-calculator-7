package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private final StringCalculator calculator = CalculatorFactory.createCalculator();

    @Test
    void 정상적인_입력() {
        String input = "1,2:3,4";
        int expected = 10;

        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 빈문자열_입력() {
        String input = "";
        int expected = 0;

        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 공백_구분자_입력() {
        String input = "1 2 3";

        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 구분자 형식입니다. 구분자는 ','와 ':'만 가능합니다.");
    }

    @Test
    void 커스텀_구분자_입력() {
        String input = "//;\\n1;2;3";
        int expected = 6;

        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 잘못된_숫자_형식() {
        String input = "1,2,a";

        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 숫자 형식입니다: a");
    }

    @Test
    void 음수_입력_시_예외() {
        String input = "1,-1";

        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수만 입력할 수 있습니다: -1");
    }

    @Test
    void 잘못된_구분자_포함() {
        String input = "1!2,3";

        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 구분자 형식입니다. 구분자는 ','와 ':'만 가능합니다.");
    }

    @Test
    void 잘못된_이스케이프_문자_입력() {
        String input = "1\\,2,3";

        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 구분자 형식입니다. 구분자는 ','와 ':'만 가능합니다.");
    }
}
