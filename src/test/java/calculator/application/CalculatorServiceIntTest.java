package calculator.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorServiceIntTest {

    CalculatorService calculatorService = new CalculatorService();

    @Test
    @DisplayName("splitAndSum 요청시 정수를 반환한다.")
    void givenSumCommand_whenSplitAndSum_thenReturnInteger() {
        // given
        String command = "1,2:3";

        // when
        int sum = calculatorService.splitAndSum(command);

        // then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("splitAndSum 요청시 예외가 발생한다.")
    void givenSumCommand_whenSplitAndSum_thenReturnError() {
        // given
        String command = "-";

        // when, then
        assertThatThrownBy(() -> calculatorService.splitAndSum(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

}