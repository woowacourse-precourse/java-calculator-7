package calculator.domain.calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "4,5:6", "7:8:9", "0:1:2:3:4:5:6:7:8:9"})
    @DisplayName("기본 구분자가 포함된 한자리 숫자로 이루어진 문자열 추출시, 정수 리스트를 반환한다.")
    void givenInputDigitStringWithBaseDelimiters_whenExtractInteger_thenReturnIntegerList(String input) {
        // given
        // when, then
        assertThat(calculator.extractInteger(input)).doesNotHaveSameClassAs(String.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"11,22,33", "444,555:666", "777:888:999", "012:123:234:345:456:567:678:789:8910:91011"})
    @DisplayName("기본 구분자가 포함된 숫자로 이루어진 문자열 추출시, 정수 리스트를 반환한다.")
    void givenInputNumberStringWithBaseDelimiters_whenExtractInteger_thenReturnIntegerList(String input) {
        // given
        // when, then
        assertThat(calculator.extractInteger(input)).doesNotHaveSameClassAs(String.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "1", "0", "9999999"})
    @DisplayName("구분자가 없는 숫자로 이루어진 문자열 추출 시, 한 개의 숫자를 반환한다.")
    void givenInputNumberWithoutDelimiters_whenExtractInteger_thenReturnIntegerList(String input) {
        // given
        // when
        List<Integer> result = calculator.extractInteger(input);

        // then
        assertThat(result.size()).isOne();
    }

    @Test
    @DisplayName("기본 구분자로 시작하는 숫자로 이루어진 문자열 추출 시, 예외가 발생한다")
    void givenInputNumberStartingWithBaseDelimiter_whenExtractInteger_thenReturnError() {
        // given
        String input = ",123";

        // when, then
        assertThatThrownBy(() -> calculator.extractInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("기본 구분자로 끝나는 숫자로 이루어진 문자열 추출 시, 예외가 발생한다")
    void givenInputNumberEndingWithBaseDelimiter_whenExtractInteger_thenReturnError() {
        // given
        String input = "123,";

        // when, then
        assertThatThrownBy(() -> calculator.extractInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,2.3", "1.2.3", "1 2 3", "1, 2, 3", "1+2+3", "123 ", " 1,2,3 ", " 123", ",", ":", ", ,", ""
    })
    @DisplayName("기본 구분자 외에 다른 문자가 포함되면 예외가 발생한다.")
    void givenInvalidInput_whenExtractInteger_thenReturnError(String input) {
        // given

        // when, then
        assertThatThrownBy(() -> calculator.extractInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 정보가 없을 경우, 0을 반환한다.")
    void givenEmptyNumbers_whenSum_thenReturnZero() {
        // given
        List<Integer> numbers = new ArrayList<>();

        // when, then
        Integer sum = calculator.sum(numbers);

        // then
        assertThat(sum).isZero();
    }

    @Test
    @DisplayName("올바른 숫자 정보가 입력되는 경우, 합을 반환한다.")
    void givenNumbers_whenSum_thenReturnSumOfNumbers() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // when, then
        Integer sum = calculator.sum(numbers);

        // then
        assertThat(sum).isEqualTo(15);
    }

}