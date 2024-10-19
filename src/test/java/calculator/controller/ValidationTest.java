package calculator.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    @DisplayName("커스텀 구분자가 포함되지 않은 입력")
    void hasCustomDelimiter_withoutCustomDelimiter() {
        // given
        String testInput = "1,2;3";

        // when
        boolean actual = Validation.hasCustomDelimiter(testInput);

        // then
        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("커스텀 구분자가 포함된 입력")
    void hasCustomDelimiter_withCustomDelimiter() {
        // given
        String testInput = "//;\n1;2;3";

        // when
        boolean actual = Validation.hasCustomDelimiter(testInput);

        // then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("모든 숫자가 양수인 입력")
    void isAllPositive_withPositiveNumbers() {
        // given
        int[] numbers = {1, 2, 3};

        // when
        boolean actual = Validation.isAllPositive(numbers);

        // then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("0이 포함된 입력")
    void isAllPositive_withZeroNumber() {
        // given
        int[] numbers = {0, 1, 2, 3};

        // when
        boolean actual = Validation.isAllPositive(numbers);

        // then
        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("음수가 포함된 입력")
    void isAllPositive_withNegativeNumber() {
        // given
        int[] numbers = {-1, 1, 2, 3};

        // when
        boolean actual = Validation.isAllPositive(numbers);

        // then
        assertThat(actual).isFalse();
    }
}
