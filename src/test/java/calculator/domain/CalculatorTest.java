/*
package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import calculator.fake.FakeCalculatorPrompt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {


    @Test
    @DisplayName("빈 문자열 입력일 경우, 0을 반환한다.")
    void givenHadEmptyString_whenSum_thenReturnZero() {
        // given
        Calculator calculator = new Calculator(new FakeCalculatorPrompt(""));

        // when, then
        int sum = calculator.sum();

        // then
        assertThat(sum).isZero();
    }

    @Test
    @DisplayName("올바른 숫자 정보가 입력되는 경우, 합을 반환한다.")
    void givenAnyInput_whenSum_thenReturnSumOfNumbers() {
        // given
        Calculator calculator = new Calculator(new FakeCalculatorPrompt("any"));

        // when, then
        int sum = calculator.sum();

        // then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 입력이 주어질 경우, 숫자의 합을 반환한다.")
    void givenCustomDelimiterInput_whenSum_thenReturnSumOfNumbers() {
        // given
        Calculator calculator = new Calculator(new FakeCalculatorPrompt("custom"));

        // when, then
        int sum = calculator.sum();

        // then
        assertThat(sum).isEqualTo(10);
    }

}*/
