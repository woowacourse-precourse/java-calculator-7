package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.DelimiterExtractor;
import calculator.domain.Separator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService(new Calculator(),
            new DelimiterExtractor(), new Separator());

    @Test
    @DisplayName("입력값을 바탕으로 계산 - 커스텀 문자열이 있는 경우")
    void calculateWithCustomDelimiter() {
        //given
        String input = "//;\\n1,2:3;4";
        Long expected = 10L;

        //when
        Long actual = calculatorService.calculate(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력값을 바탕으로 계산 - 커스텀 문자열이 없는 경우")
    void calculateWithDefaultDelimiter() {
        //given
        String input = "1,2:3";
        Long expected = 6L;

        //when
        Long actual = calculatorService.calculate(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력값을 바탕으로 계산 - 빈 문자열이 들어와 성공한 경우")
    void calculateWithEmptyInput() {
        //given
        String input = "";
        Long expected = 0L;

        //when
        Long actual = calculatorService.calculate(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력값을 바탕으로 계산 - //으로 시작하나 \\n이 없어 실패한 경우")
    void calculateWithWrongInputFormat() {
        //given
        String input = "//;1:2;3";

        //when
        //then
        Assertions.assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값을 바탕으로 계산 - 정상적인 문자열이 여러번 반복되어 실패한 경우")
    void calculateWithMultipleValidInput() {
        //given
        String input = "//;\\n1:2;3//-\\n1:2";

        //when
        //then
        Assertions.assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값을 바탕으로 계산 - 오버플로우가 발생해 실패한 경우")
    void calculateWithOverflow() {
        //given
        String input = "1," + String.valueOf(Long.MAX_VALUE);

        //when
        //then
        Assertions.assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값을 바탕으로 계산 - 음수가 포함되어 실패한 경우")
    void calculateWithNegitiveNumber() {
        //given
        String input = "//;\\n1:2;-3";

        //when
        //then
        Assertions.assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값을 바탕으로 계산 - 구분자로 나누었을 때 빈 문자열이 있어 실패한 경우")
    void calculateWithEmptyNumber() {
        //given
        String input = "//;\\n1:;3";

        //when
        //then
        Assertions.assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값을 바탕으로 계산 - 구분자로 나누었을 때 문자가 있어 실패한 경우")
    void calculateWithCharacterNumber() {
        //given
        String input = "//;\\n1:2a;3";

        //when
        //then
        Assertions.assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}