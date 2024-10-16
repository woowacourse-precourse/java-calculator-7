package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("숫자 정보가 없을 경우, 0을 반환한다.")
    void givenEmptyNumbers_whenSum_thenReturnZero() {
        // given
        Calculator calculator = new Calculator("");

        // when, then
        int sum = calculator.sum();

        // then
        assertThat(sum).isZero();
    }

    @Test
    @DisplayName("올바른 숫자 정보가 입력되는 경우, 합을 반환한다.")
    void givenNumbers_whenSum_thenReturnSumOfNumbers() {
        // given
        Calculator calculator = new Calculator("1,2:3:4,5");

        // when, then
        int sum = calculator.sum();

        // then
        assertThat(sum).isEqualTo(15);
    }

}