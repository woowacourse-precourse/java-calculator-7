package calculator.domain;

import static calculator.TestConstants.BLACK_NUMBER_SIZE;
import static calculator.TestConstants.BLANK_INPUT;
import static calculator.TestConstants.BLANK_NUMBER;
import static calculator.TestConstants.FIRST_IDX;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {
    @Test
    @DisplayName("빈 문자열을 입력했을 경우 0 값만 갖는다.")
    void BlankInputNoException () {
        // given
        String input = BLANK_INPUT;

        // when
        Numbers numbers = new Numbers(input);

        // then
        Number expectedNumber = new Number(BLANK_NUMBER);
        assertThat(numbers.size()).isEqualTo(BLACK_NUMBER_SIZE);
        assertThat(numbers.compareNumber(FIRST_IDX, expectedNumber)).isTrue();
    }
}