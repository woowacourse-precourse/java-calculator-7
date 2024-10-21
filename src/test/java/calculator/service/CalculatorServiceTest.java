package calculator.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void 숫자_하나_테스트() {
        String input = "1";

        String result = calculatorService.calculate(input);

        assertThat(result).isEqualTo("1");
    }

    @Test
    void 숫자_두개_테스트() {
        String input = "1,2";

        String result = calculatorService.calculate(input);

        assertThat(result).isEqualTo("3");
    }

    @Test
    void 숫자_세개_테스트() {
        String input = "1,2,3";

        String result = calculatorService.calculate(input);

        assertThat(result).isEqualTo("6");
    }

    @Test
    void 매우_큰_숫자_테스트() {
        String input = "1000000000000,20,3";

        String result = calculatorService.calculate(input);

        assertThat(result).isEqualTo("1000000000023");
    }

    @Test
    void 음수_예외_테스트() {
        String input = "-1,2,3";

        assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 숫자_아닌_문자_테스트() {
        String input = "a,2,3";

        assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 빈_문자열_테스트() {
        String input = "";

        String result = calculatorService.calculate(input);

        assertThat(result).isEqualTo("0");
    }

    @Test
    void 커스텀_구분자_닫기_없음_테스트() {
        String input = "//;13;21";

        assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(RuntimeException.class);
    }

}
