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

}
