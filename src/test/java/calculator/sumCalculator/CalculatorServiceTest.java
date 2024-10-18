package calculator.sumCalculator;

import calculator.sumCalculator.domain.Calculator;
import calculator.sumCalculator.util.DelimiterParser;
import calculator.sumCalculator.util.NumberParser;
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
        DelimiterParser delimiterParser = new DelimiterParser();
        NumberParser numberParser = new NumberParser();
        calculatorService =  new CalculatorService(numberParser, delimiterParser);
    }

    @Test
    @DisplayName("입력 문자열에서 기본 구분자 사용 여부를 판딘한다.")
    void hasDefaultDelimiter() {
        String prefix = "//";
        String defaultDelimiter = "1,2:3";
        String customDelimiter = "//;\n1;2;3";
        boolean hasCustomDelimiter1 = defaultDelimiter.startsWith(prefix);
        boolean hasCustomDelimiter2 = customDelimiter.startsWith(prefix);
        assertThat(false).isEqualTo(hasCustomDelimiter1);
        assertThat(true).isEqualTo(hasCustomDelimiter2);
    }

    @Test
    @DisplayName("기본 구분자를 사용해서 더한다.")
    void sumUsingDefaultDelimiter() {
        String input = "1,2,3";
        int result = calculatorService.sum(input);
        assertThat(6).isEqualTo(result);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용해서 더한다.")
    void sumUsingCustomDelimiter() {
        String input = "//;\n1;2;3";
        int result = calculatorService.sum(input);
        assertThat(6).isEqualTo(result);
    }

    @Test
    @DisplayName("덧셈을 성공한다.")
    void successCalculate() {
        List<Integer> numberList = List.of(1, 2, 3);
        int inputSum = numberList.stream().mapToInt(i -> i).sum();
        Calculator calculator = Calculator.of(numberList);
        Integer result = calculator.sum();
        assertThat(inputSum).isEqualTo(result);
    }

    @Test
    @DisplayName("예외 케이스 - 잘못된 기본 구분자를 사용하여 덧셈을 실패한다.")
    void failContainInvalidDefaultDelimiter() {
        String numbersContainZero = "0,2:3";
        assertThatThrownBy(() -> calculatorService.sum(numbersContainZero))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산식에 올바르지 않은 입력값이 포함되어 있습니다.");
    }

    @Test
    @DisplayName("예외 케이스 - 기본 구분자 사용 시 음수를 포함하면 덧셈을 실패한다")
    void failContainNegative() {
        String numbersContainNegative = "-100;2;3";
        assertThatThrownBy(() -> calculatorService.sum(numbersContainNegative))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산식에 올바르지 않은 입력값이 포함되어 있습니다.");
    }

    @Test
    @DisplayName("예외 케이스 - 커스텀 구분자 사용 시 음수를 포함하면 덧셈을 실패한다")
    void failContainNegativeCustomDelimiter() {
        String numbersContainNegative = "//;\n1;-2;3";
        assertThatThrownBy(() -> calculatorService.sum(numbersContainNegative))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값에는 음수가 포함될 수 없습니다.");
    }

    @Test
    @DisplayName("예외 케이스 - 0을 포함하면 덧셈을 실패한다")
    void failContainZero() {
        String numbersContainZero = "0,2;3";
        assertThatThrownBy(() -> calculatorService.sum(numbersContainZero))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값에는 0이 포함될 수 없습니다.");
    }

}