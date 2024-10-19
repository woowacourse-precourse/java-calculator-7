package calculator.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorValidatorTest {

    CalculatorValidator calculatorValidator = new CalculatorValidator();

    @Test
    void 예외_테스트_커스텀_구분자_존재확인1() {
        String inputString = "123";
        Assertions.assertFalse(calculatorValidator.validateCustomDelimiterInput(inputString));
    }

    @Test
    void 예외_테스트_커스텀_구분자_존재확인2() {
        String inputString = "/";
        Assertions.assertFalse(calculatorValidator.validateCustomDelimiterInput(inputString));
    }

    @Test
    void 예외_테스트_커스텀_구분자_통과() {
        String inputString = "//1\\n";
        Assertions.assertTrue(calculatorValidator.validateCustomDelimiterInput(inputString));
    }

    @Test
    void 예외_테스트_커스텀_구분자_문자_접미사_누락() {
        String inputString = "//";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorValidator.validateCustomDelimiterInput(inputString);
        });
    }

    @Test
    void 예외_테스트_커스텀_구분자_문자_누락() {
        String inputString = "//\\n";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorValidator.validateCustomDelimiterInput(inputString);
        });
    }

    @Test
    void 예외_테스트_커스텀_구분자_접미사_누락() {
        String inputString = "//1";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorValidator.validateCustomDelimiterInput(inputString);
        });
    }

    @Test
    void 예외_테스트_커스텀_구분자_형식_틀림() {
        String inputString = "//1\\m";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorValidator.validateCustomDelimiterInput(inputString);
        });
    }

    @Test
    void 예외_테스트_커스텀_구분자_문자열_입력() {
        String inputString = "//123\\n";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorValidator.validateCustomDelimiterInput(inputString);
        });
    }

    @Test
    void 분리된_문자_토큰_유효성_확인1() {
        String inputToken = "1 23";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorValidator.validateInputToken(inputToken);
        });
    }

    @Test
    void 분리된_문자_토큰_유효성_확인2() {
        String inputToken = " ";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorValidator.validateInputToken(inputToken);
        });
    }

    @Test
    void 분리된_문자_토큰_유효성_확인3() {
        String inputToken = "1234;";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorValidator.validateInputToken(inputToken);
        });
    }
}
