package calculator.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void 빈_문자열_입력_테스트() {
        String input = "";
        int result = calculatorService.calculate(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 기본_구분자_입력_테스트() {
        String input = "1,2:3";
        int result = calculatorService.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_입력_테스트() {
        String input = "//;\\n1;2;3";
        int result = calculatorService.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자와_기본_구분자_혼합_테스트() {
        String input = "//;\\n1;2,3:4";
        int result = calculatorService.calculate(input);
        assertThat(result).isEqualTo(10);
    }
}
