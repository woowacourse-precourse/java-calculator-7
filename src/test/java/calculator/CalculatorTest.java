package calculator;

import calculator.parser.InputStringParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CalculatorTest {

    private final Calculator calculator = new Calculator(new InputStringParser(), new ListCalculator());

    @Test
    @DisplayName("string을 주면 그 합을 계산한다.")
    void 합_계산_테스트() {
        String input = "1:2:3:4:5,6,7,8:9,10";
        Assertions.assertThat(calculator.calculate(input)).isEqualTo(55);
    }

    @Test
    @DisplayName("커스텀 구분자가 있는 string을 주면 그 합을 계산한다.")
    void 커스텀_구분자_합_계산_테스트() {
        String input = "//@#$@#%!@$\\n1@#$@#%!@$2@#$@#%!@$3@#$@#%!@$4@#$@#%!@$5@#$@#%!@$6@#$@#%!@$7@#$@#%!@$8@#$@#%!@$9@#$@#%!@$10";
        Assertions.assertThat(calculator.calculate(input)).isEqualTo(55);
    }

    @Test
    @DisplayName("잘못된 구분자가 있는 string을 주면 IllegalArgumentException을 던진다.")
    void 합_계산_테스트_예외_잘못된_구분자() {
        String input = "//@#$@#%!@$\n1@#$@#%!@$2@#$@#%!@$3@#$@#%!@$4@#$@#%!@$5@#$@#%!@$6@#$@#%!@$7@#$@#%!@$8@#$@#%!@$9@#$@#%!@$10";
        Assertions.assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 형식의 string을 주면 IllegalArgumentException을 던진다.")
    void 합_계산_테스트_예외_잘못된_형식() {
        String input = "//@#$@#%!@$\\n1@#$@#%!@$2@$@#%!@$3@#$@#%!@$4@#$@#%!@$5@#$@#%!@$6@#$@#%!@$7@#$@#%!@$8@#$@#%!@$9@#$@#%!@$10";
        Assertions.assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0이나 음수가 있는 string을 주면 IllegalArgumentException을 던진다.")
    void 합_계산_테스트_예외_양수가_아닌_경우() {
        String input = "1:2:3:4:5,6,7,8:9,0";
        Assertions.assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}