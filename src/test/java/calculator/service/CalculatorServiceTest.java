package calculator.service;

import calculator.domain.Calculator;
import calculator.validator.CalculatorValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService;
    private Calculator calculator;

    @BeforeEach
    void 초기화() {
        CalculatorValidator validator = new CalculatorValidator();
        calculator = new Calculator(validator);
        calculatorService = new CalculatorService(calculator);
    }

    @Test
    void 빈_입력_합계() {
        String input = "";
        int result = calculatorService.calculateSum(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 단일_숫자_합계() {
        String input = "5";
        int result = calculatorService.calculateSum(input);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 두_숫자_쉼표_합계() {
        String input = "1,2";
        int result = calculatorService.calculateSum(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 여러_숫자_쉼표_합계() {
        String input = "1,2,3,4,5";
        int result = calculatorService.calculateSum(input);
        assertThat(result).isEqualTo(15);
    }

    @Test
    void 쉼표와_줄바꿈_합계() {
        String input = "1,2\n3,4";
        assertThatThrownBy(() -> calculatorService.calculateSum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자_합계() {
        String input = "//;\n1;2;3";
        int result = calculatorService.calculateSum(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_예외() {
        String input = "//;;\n1;2;3";
        assertThatThrownBy(() -> calculatorService.calculateSum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자_선언부_없음_예외() {
        String input = "//;1;2;3";
        assertThatThrownBy(() -> calculatorService.calculateSum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_포함_예외() {
        String input = "1,-2,3";
        assertThatThrownBy(() -> calculatorService.calculateSum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 잘못된_숫자_형식_예외() {
        String input = "1,2,a";
        assertThatThrownBy(() -> calculatorService.calculateSum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_포함_합계() {
        String input = " 1 , 2 : 3 ";
        int result = calculatorService.calculateSum(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀과_기본_구분자_혼합_예외() {
        String input = "//;\n1;2,3\n4";
        assertThatThrownBy(() -> calculatorService.calculateSum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀과_기본_구분자_혼합_합계() {
        String input1 = "//#\n1#2,3";
        int result1 = calculatorService.calculateSum(input1);
        assertThat(result1).isEqualTo(6);
    }
}
