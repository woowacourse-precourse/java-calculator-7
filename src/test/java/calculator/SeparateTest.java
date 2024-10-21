package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SeparateTest {
    @DisplayName("기본 구분자를 기준으로 분리")
    @Test
    void separateByBasicSeparator() {
        String expression = "1:2,3";

        Calculator calculator = new Calculator();
        CalculatorService calculatorService = new CalculatorService();

        String[] tokens = calculatorService.separate(calculator.getSeparators(), expression);

        assertThat(tokens).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자를 기준으로 분리")
    @Test
    void separateByCustomSeparator() {
        String expression = "//;\\n1;2;3";

        Calculator calculator = new Calculator();
        CalculatorService calculatorService = new CalculatorService();

        String customSeparator = calculatorService.getCustomSeparator(expression);
        calculator.addSeparator(customSeparator);
        String removeCustomSeparatorDefinition = calculatorService.removeCustomSeparatorDefinition(expression);

        String[] tokens = calculatorService.separate(calculator.getSeparators(), removeCustomSeparatorDefinition);

        assertThat(tokens).containsExactly("1", "2", "3");
    }

}
