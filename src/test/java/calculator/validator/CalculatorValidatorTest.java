package calculator.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorValidatorTest {

    CalculatorValidator calculatorValidator = new CalculatorValidator();

    @Test
    void 예외_테스트_커스텀_구분자_존재확인1() {
        String input = "123";
        Assertions.assertFalse(calculatorValidator.validateCustomDelimiterInput(input));
    }

    @Test
    void 예외_테스트_커스텀_구분자_존재확인2() {
        String input = "/";
        Assertions.assertFalse(calculatorValidator.validateCustomDelimiterInput(input));
    }

    @Test
    void 예외_테스트_커스텀_구분자_통과() {
        String input = "//1\\n";
        Assertions.assertTrue(calculatorValidator.validateCustomDelimiterInput(input));
    }

    @Test
    void 예외_테스트_커스텀_구분자_문자_접미사_누락() {
        String input = "//";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorValidator.validateCustomDelimiterInput(input);
        });
    }

    @Test
    void 예외_테스트_커스텀_구분자_문자_누락() {
        String input = "//\\n";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorValidator.validateCustomDelimiterInput(input);
        });
    }

    @Test
    void 예외_테스트_커스텀_구분자_접미사_누락() {
        String input = "//1";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorValidator.validateCustomDelimiterInput(input);
        });
    }

    @Test
    void 예외_테스트_커스텀_구분자_형식_틀림() {
        String input = "//1\\m";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorValidator.validateCustomDelimiterInput(input);
        });
    }

    @Test
    void 예외_테스트_커스텀_구분자_문자열_입력() {
        String input = "//123\\n";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorValidator.validateCustomDelimiterInput(input);
        });
    }
}
