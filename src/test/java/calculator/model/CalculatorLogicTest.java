package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorLogicTest {
    CalculatorLogic calculatorLogic = new CalculatorLogic();

    @Test
    @DisplayName("기본 구분자 추출 테스트")
    void testDefaultDelimiter() {
        String input = "1,2:3";
        String delimiter = calculatorLogic.extractDelimiter(input);
        assertThat(delimiter).isEqualTo(",|:");
    }

    @Test
    @DisplayName("사용자 정의 구분자 추출 테스트")
    void testCustomDelimiter() {
        String input = "//+\n1+2+3";
        String delimiter = calculatorLogic.extractDelimiter(input);
        assertThat(delimiter).isEqualTo("+");
    }

    @Test
    @DisplayName("기본 구분자 통한 숫자 추출 테스트")
    void extractDefaultNumbers() {
        String input = "1,2:3";
        String delimiter = calculatorLogic.extractDelimiter(input);
        assertThat(calculatorLogic.extractNumbers(input, delimiter)).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("사용자 정의 구분자 통한 숫자 추출 테스트")
    void extractCustomNumbers() {
        String input = "1;2;3";
        String delimiter = ";";
        assertThat(calculatorLogic.extractNumbers(input, delimiter)).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("dangling 문자 구분자 사용시 숫자 추출 테스트")
    void extractDanglingNumbers() {
        String input = "1+2+3";
        String delimiter = "\\+";
        assertThat(calculatorLogic.extractNumbers(input, delimiter)).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("숫자들의 합 계산 테스트")
    void calculate() {
        List<Integer> numbers = List.of(1, 2, 3);
        assertThat(calculatorLogic.calculate(numbers)).isEqualTo(6);
    }
}