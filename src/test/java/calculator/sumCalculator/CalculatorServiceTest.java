package calculator.sumCalculator;

import calculator.sumCalculator.domain.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
        Integer result = calculatorService.sumNumbers(Calculator.of(numberList));
        assertThat(inputSum).isEqualTo(result);
    }

    @Test
    @DisplayName("예외_케이스_음수를_포함하여_덧셈을_실패한다")
    void failContainNegative() {
        List<Integer> numbersContainNegative = List.of(-1, 2, 3);
        assertThatThrownBy(() -> calculatorService.sumNumbers(Calculator.of(numbersContainNegative)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값에는 음수가 포함될 수 없습니다.");
    }

    @Test
    @DisplayName("예외_케이스_0을_포함하여_덧셈을_실패한다")
    void failContainZero() {
        List<Integer> numbersContainNegative = List.of(0, 2, 3);
        assertThatThrownBy(() -> calculatorService.sumNumbers(Calculator.of(numbersContainNegative)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값에는 0이 포함될 수 없습니다.");
    }

}