package calculator.domain;

import static calculator.TestConstants.BLANK_INPUT;
import static calculator.TestConstants.BLANK_NUMBER;
import static calculator.TestConstants.BLANK_NUMBER_SIZE;
import static calculator.TestConstants.FIRST_IDX;
import static calculator.TestConstants.FIRST_NUM;
import static calculator.TestConstants.INPUT_CUSTOM_SEPARATOR;
import static calculator.TestConstants.INPUT_START_NUMBER;
import static calculator.TestConstants.NUM_CNT;
import static calculator.TestConstants.SECOND_IDX;
import static calculator.TestConstants.SECOND_NUM;
import static calculator.TestConstants.THIRD_IDX;
import static calculator.TestConstants.THIRD_NUM;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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
        assertThat(numbers.size()).isEqualTo(BLANK_NUMBER_SIZE);
        assertThat(numbers.compareNumber(FIRST_IDX, expectedNumber)).isTrue();
    }

    @Test
    @DisplayName("커스텀 구분자가 포함된 문자열을 입력했을 경우, 커스텀 구분자를 통해 숫자들을 추출한다.")
    void GetNumbersByCustomSeparator () {
        // given
        String input = INPUT_CUSTOM_SEPARATOR;

        // when
        Numbers numbers = new Numbers(input);

        // then
        Number expectedFirstNum = new Number(FIRST_NUM);
        Number expectedSecondNum = new Number(SECOND_NUM);
        Number expectedThirdNum = new Number(THIRD_NUM);

        assertThat(numbers.size()).isEqualTo(NUM_CNT);
        assertThat(numbers.compareNumber(FIRST_IDX, expectedFirstNum)).isTrue();
        assertThat(numbers.compareNumber(SECOND_IDX, expectedSecondNum)).isTrue();
        assertThat(numbers.compareNumber(THIRD_IDX, expectedThirdNum)).isTrue();

    }

    @Test
    @DisplayName("입력이 숫자로 시작할 경우, 입력 문자열을 쉼표(,) 또는 콜론(:)으로 분리하여 숫자들을 추출한다.")
    void GetNumbersByBasicSeparator () {
        // given
        String input = INPUT_START_NUMBER;

        // when
        Numbers numbers = new Numbers(input);

        // then
        Number expectedFirstNum = new Number(FIRST_NUM);
        Number expectedSecondNum = new Number(SECOND_NUM);
        Number expectedThirdNum = new Number(THIRD_NUM);

        assertThat(numbers.size()).isEqualTo(NUM_CNT);
        assertThat(numbers.compareNumber(FIRST_IDX, expectedFirstNum)).isTrue();
        assertThat(numbers.compareNumber(SECOND_IDX, expectedSecondNum)).isTrue();
        assertThat(numbers.compareNumber(THIRD_IDX, expectedThirdNum)).isTrue();

    }

}