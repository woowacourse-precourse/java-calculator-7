package calculator.controller;

import static calculator.TestConstants.BLANK_INPUT;
import static calculator.TestConstants.BLANK_NUMBER_SIZE;
import static calculator.TestConstants.INPUT_CUSTOM_SEPARATOR;
import static calculator.TestConstants.INPUT_START_NUMBER;
import static calculator.TestConstants.INVALID_INPUT;
import static calculator.TestConstants.NUM_CNT;
import static calculator.common.Constants.INVALID_INPUT_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import calculator.domain.Numbers;
import calculator.view.InputView;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setup () {
        InputView inputView = new InputView();
        calculator = new Calculator(inputView);
    }

    @Test
    @DisplayName("잘못된 입력을 했을 경우 에러를 반환한다.")
    void invalidInputThrowsException () {
        // given
        String input = INVALID_INPUT;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.handleInput(input);
        });

        assertEquals(INVALID_INPUT_FORMAT, exception.getMessage());
    }

    @Test
    @DisplayName("빈 문자열을 입력했을 경우 Numbers는 숫자 0만 가진다.")
    void BlankInputNoException () {
        // given
        String input = BLANK_INPUT;

        // when
        Numbers numbers = calculator.handleInput(input);

        // then
        assertThat(numbers.size()).isEqualTo(BLANK_NUMBER_SIZE);
    }

    @Test
    @DisplayName("커스텀 문자열을 입력했을 경우 입력된 수들을 Numbers에 저장한다.")
    void InputCustomSeparatorNoException () {
        // given
        String input = INPUT_CUSTOM_SEPARATOR;

        // when
        Numbers numbers = calculator.handleInput(input);

        // then
        assertThat(numbers.size()).isEqualTo(NUM_CNT);
    }

    @Test
    @DisplayName("빈 문자열을 입력했을 경우  입력된 수들을 Numbers에 저장한다.")
    void InputStartNumberNoException () {
        // given
        String input = INPUT_START_NUMBER;

        // when
        Numbers numbers = calculator.handleInput(input);

        // then
        assertThat(numbers.size()).isEqualTo(NUM_CNT);
    }

}