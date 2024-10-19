package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    @DisplayName("기본구분자 ',' 계산 테스트")
    void testDefaultDelimiter1() {
        String input = "1,2,3";
        int result = calculatorService.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("기본구분자 ':' 계산 테스트")
    void testDefaultDelimiter2() {
        String input = "1:2:3";
        int result = calculatorService.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 포함된 기본 구분자 연산")
    void testContainNegativeDefaultDelimiter() {
        String input = "1,-1,3";

        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.calculate(input);
        });
    }

    @Test
    @DisplayName("0이 포함된 기본 구분자 연산")
    void testContainZeroDefaultDelimiter() {
        String input = "1,0,1";
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.calculate(input);
        });
    }

    @Test
    @DisplayName("dangling 문자 구분자 사용시 숫자 추출 테스트")
    void extractDanglingNumbers() {
        String input = "//?\n1?2?3";
        int result = calculatorService.calculate(input);
        assertThat(result).isEqualTo(6);
    }
}
