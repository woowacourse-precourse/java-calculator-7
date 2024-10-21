package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("빈 문자열 입력일 경우, 0을 반환한다.")
    void givenEmptyList_whenSum_thenReturnZero() {
        // given
        List<BigInteger> numbers = List.of();

        // when, then
        BigInteger sum = calculator.sum(numbers);

        // then
        assertThat(sum).isEqualTo(BigInteger.ZERO);
    }

    @Test
    @DisplayName("숫자 리스트가 주어질 경우, 합을 반환한다.")
    void givenNumbers_whenSum_thenReturnSumOfNumbers() {
        // given
        List<BigInteger> numbers = List.of(BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3));

        // when, then
        BigInteger sum = calculator.sum(numbers);

        // then
        assertThat(sum).isEqualTo(BigInteger.valueOf(6));
    }

    @Test
    @DisplayName("Int형 최대 정수 두 개가 주어질 경우, 합을 반환한다.")
    void givenMaxIntegerNumbers_whenSum_thenReturnSumOfNumbers() {
        // given
        BigInteger number = BigInteger.valueOf(Integer.MAX_VALUE);
        List<BigInteger> numbers = List.of(number, number);

        // when, then
        BigInteger sum = calculator.sum(numbers);

        // then
        BigInteger expected = number.add(number);
        assertThat(sum).isEqualTo(expected);
    }

    @Test
    @DisplayName("Long형 최대 정수 두 개가 주어질 경우, 합을 반환한다.")
    void givenMaxLongNumbers_whenSum_thenReturnSumOfNumbers() {
        // given
        BigInteger number = BigInteger.valueOf(Long.MAX_VALUE);
        List<BigInteger> numbers = List.of(number, number);

        // when, then
        BigInteger sum = calculator.sum(numbers);

        // then
        BigInteger expected = number.add(number);
        assertThat(sum).isEqualTo(expected);
    }
    @Test
    @DisplayName("100자리 큰 수 두 개가 주어질 경우, 정확한 합을 반환한다.")
    void givenVeryLargeNumbers_whenSum_thenReturnCorrectSum() {
        // given
        String largeNumberString = "9".repeat(100);
        BigInteger largeNumber = new BigInteger(largeNumberString);
        List<BigInteger> numbers = List.of(largeNumber, largeNumber);

        // when
        BigInteger sum = calculator.sum(numbers);

        // then
        BigInteger expected = largeNumber.add(largeNumber);
        assertThat(sum).isEqualTo(expected);
        assertThat(sum.toString()).hasSize(101);
    }

}
