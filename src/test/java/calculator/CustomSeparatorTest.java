package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomSeparatorTest {
    @DisplayName("커스텀 구분자 구분자에 추가되었는지 확인")
    @Test
    void extractCustomSeparator() {
        String expression = "//;\\n1;2;3";

        Calculator calculator = new Calculator();
        CalculatorService calculatorService = new CalculatorService();

        String customSeparator = calculatorService.getCustomSeparator(expression);
        calculator.addSeparator(customSeparator);

        assertThat(calculator.getSeparators()).contains(";");
    }
}
