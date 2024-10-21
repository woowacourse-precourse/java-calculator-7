package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import calculator.utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionTest {
    @DisplayName("숫자로 입력했는지 확인")
    @Test
    void validateIsNumber() {
        String expression = "1:/2";

        Calculator calculator = new Calculator();
        CalculatorService calculatorService = new CalculatorService();

        assertThatThrownBy(() -> {
            calculatorService.separate(calculator.getSeparators(), expression);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.NUMBER_FORMAT_EXCEPTION_MESSAGE);
    }

    @DisplayName("양수로 입력했는지 확인")
    @Test
    void validateIsPositiveNumber() {
        String expression = "1:-2";

        Calculator calculator = new Calculator();
        CalculatorService calculatorService = new CalculatorService();

        assertThatThrownBy(() -> {
            calculatorService.separate(calculator.getSeparators(), expression);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.POSITIVE_NUMBER_EXCEPTION_MESSAGE);

    }

    @DisplayName("커스텀 구분자는 하나의 문자로 입력했는지 확인")
    @Test
    void validateSingleCharacterSeparator() {
        String expression = "//;;\\n1:23";

        CalculatorService calculatorService = new CalculatorService();

        assertThatThrownBy(() -> {
            calculatorService.getCustomSeparator(expression);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.CUSTOM_SEPARATOR_EXCEPTION_MESSAGE);
    }

    @DisplayName("커스텀 구분자 없을 때, 양수부터 입력했는지 확인")
    @Test
    void validateStartPositiveNumber_noCustom() {
        String expression = ":23,1";

        Calculator calculator = new Calculator();
        CalculatorService calculatorService = new CalculatorService();

        assertThatThrownBy(() -> {
            calculatorService.separate(calculator.getSeparators(), expression);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.START_POSITIVE_NUMBER_EXCEPTION_MESSAGE);
    }

    @DisplayName("커스텀 구분자 있을 때, 양수부터 입력했는지 확인")
    @Test
    void validateStartPositiveNumber_custom() {
        String expression = "//;\\n;1:23";

        Calculator calculator = new Calculator();
        CalculatorService calculatorService = new CalculatorService();

        String customSeparator = calculatorService.getCustomSeparator(expression);
        calculator.addSeparator(customSeparator);
        String removeCustomSeparatorDefinition = calculatorService.removeCustomSeparatorDefinition(expression);

        assertThatThrownBy(() -> {
            calculatorService.separate(calculator.getSeparators(), removeCustomSeparatorDefinition);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.START_POSITIVE_NUMBER_EXCEPTION_MESSAGE);
    }
}
