package calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CaculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    @DisplayName("계산을 성공한다.")
    void calculateSuccess() {
        // given
        String input = "//;\n1;2,3";

        // when
        int result = calculatorService.calculate(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("리스트의 총합을 구한다.")
    void sumSuccess() {
        // given
        List<Integer> numbers = List.of(1, 2, 3);

        // when
        int result = calculatorService.sum(numbers);

        // then
        assertThat(result).isEqualTo(6);
    }

}
