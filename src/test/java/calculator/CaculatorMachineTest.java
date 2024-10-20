package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CaculatorMachineTest {

    @DisplayName("기본 구분자 덧셈")
    @Test
    void BaseDelimiterTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "1,2";
        // when
        int result = calculatorMachine.calculate(userInput);

        // then
        System.out.println(result);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("커스텀 구분자 덧셈")
    @Test
    void CustomDelimiterTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "//;\\n1;2";
        // when
        int result = calculatorMachine.calculate(userInput);

        // then
        System.out.println(result);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("커스텀 구분자 + 기본 구분자 덧셈")
    @Test
    void CustomDelimiterAndBaseDelimiterTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "//;\\n1;2,3:2";
        // when
        int result = calculatorMachine.calculate(userInput);

        // then
        System.out.println(result);
        assertThat(result).isEqualTo(8);
    }
}