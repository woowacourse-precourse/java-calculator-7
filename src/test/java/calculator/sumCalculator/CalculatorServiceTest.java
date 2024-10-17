package calculator.sumCalculator;

import calculator.sumCalculator.domain.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService =  new CalculatorService();
    }

    @Test
    @DisplayName("덧셈을_성공한다")
    void successCalculate() {
        List<Integer> numberList = List.of(1, 2, 3);
        int inputSum = numberList.stream().mapToInt(i -> i).sum();
        Integer caculatorResult = calculatorService.sumNumbers(Calculator.of(numberList));
        assertThat(inputSum).isEqualTo(caculatorResult);
    }

}