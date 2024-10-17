package calculator.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.application.dto.CalculatorSumRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorServiceIntTest {

    CalculatorService calculatorService = new CalculatorService();

    @Test
    @DisplayName("splitAndSum 요청시 정수를 반환한다.")
    void givenSumRequest_whenSplitAndSum_thenReturnInteger() {
        // given
        CalculatorSumRequest request = new CalculatorSumRequest("1,2:3");

        // when
        int sum = calculatorService.splitAndSum(request);

        // then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("splitAndSum 요청시 예외가 발생한다.")
    void givenSumRequest_whenSplitAndSum_thenReturnError() {
        // given
        CalculatorSumRequest request = new CalculatorSumRequest("-");

        // when, then
        assertThatThrownBy(() -> calculatorService.splitAndSum(request))
                .isInstanceOf(IllegalArgumentException.class);
    }

}