package calculator.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CalculatorServiceTest {
    CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    @DisplayName("구분자 ';'와 함께 정상 계산 테스트")
    void testCalculateWithCustomDelimiter() {
        String input = "//;\n1;2;3";
        int result = calculatorService.calculate(input);
        assertThat(result).isEqualTo(6);

    }

    @Test
    @DisplayName("기본 구분자 ',' 와 ':'로 계산")
    void testCalculateWithDefaultDelimiter() {
        String input = "1,2:3";
        int result = calculatorService.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("dangling 문자 구분자 사용시 숫자 추출 테스트")
    void extractDanglingNumbers() {
        String input = "//?\n1?2?3";
        int result = calculatorService.calculate(input);
        assertThat(result).isEqualTo(6);
    }
}