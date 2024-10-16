package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import calculator.fake.FakePrompt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("null 입력일 경우, 0을 반환한다.")
    void givenHadNullPrompt_whenSum_thenReturnZero() {
        // given
        Calculator calculator = new Calculator(new FakePrompt(null));

        // when, then
        int sum = calculator.sum();

        // then
        assertThat(sum).isZero();
    }

    @Test
    @DisplayName("빈 문자열 입력일 경우, 0을 반환한다.")
    void givenHadEmptyString_whenSum_thenReturnZero() {
        // given
        Calculator calculator = new Calculator(new FakePrompt(""));

        // when, then
        int sum = calculator.sum();

        // then
        assertThat(sum).isZero();
    }

    @Test
    @DisplayName("올바른 숫자 정보가 입력되는 경우, 합을 반환한다.")
    void givenNumbers_whenSum_thenReturnSumOfNumbers() {
        // given
        Calculator calculator = new Calculator(new FakePrompt("any"));

        // when, then
        int sum = calculator.sum();

        // then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("올바른 숫자와 구분자가 정보가 입력되는 경우, 합을 반환한다.")
    void givenNumbersWithDelimiter_whenSum_thenReturnSumOfNumbers() {
        // given
        Calculator calculator = new Calculator(new FakePrompt("any", '?'));

        // when, then
        int sum = calculator.sum();

        // then
        assertThat(sum).isEqualTo(10);
    }

}