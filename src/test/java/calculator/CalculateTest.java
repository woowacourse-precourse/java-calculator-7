package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculateTest {
    @DisplayName("기본 구분자만 있는 경우 합 계산")
    @Test
    void calculateByBasicSeparator() {
        String expression = "1:2,3";

        Calculator calculator = new Calculator();
        CalculatorService calculatorService = new CalculatorService();

        String[] tokens = calculatorService.separate(calculator.getSeparators(), expression);
        int[] numbers = calculatorService.convertToIntArray(tokens);

        calculator.setNumber(numbers);
        calculator.calc();

        assertThat(calculator.getResult()).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자로 합 계산")
    @Test
    void calculateByCustomSeparator() {
        String expression = "//;\\n1;2;3";

        Calculator calculator = new Calculator();
        CalculatorService calculatorService = new CalculatorService();

        String customSeparator = calculatorService.getCustomSeparator(expression);
        calculator.addSeparator(customSeparator);
        String removeCustomSeparatorDefinition = calculatorService.removeCustomSeparatorDefinition(expression);

        String[] tokens = calculatorService.separate(calculator.getSeparators(), removeCustomSeparatorDefinition);
        int[] numbers = calculatorService.convertToIntArray(tokens);

        calculator.setNumber(numbers);
        calculator.calc();

        assertThat(calculator.getResult()).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자와 기본 구분자로 합 계산")
    @Test
    void calculateBySeparator() {
        String expression = "//;\\n1;2,3";

        Calculator calculator = new Calculator();
        CalculatorService calculatorService = new CalculatorService();

        String customSeparator = calculatorService.getCustomSeparator(expression);
        calculator.addSeparator(customSeparator);
        String removeCustomSeparatorDefinition = calculatorService.removeCustomSeparatorDefinition(expression);

        String[] tokens = calculatorService.separate(calculator.getSeparators(), removeCustomSeparatorDefinition);
        int[] numbers = calculatorService.convertToIntArray(tokens);

        calculator.setNumber(numbers);
        calculator.calc();

        assertThat(calculator.getResult()).isEqualTo(6);
    }

}
