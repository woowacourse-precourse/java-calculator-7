package calculator.controller;

import static calculator.TestConstants.BLANK_INPUT;
import static calculator.TestConstants.INPUT_CUSTOM_SEPARATOR;
import static calculator.TestConstants.INPUT_START_NUMBER;
import static calculator.TestConstants.INVALID_INPUT;
import static calculator.common.Constants.INVALID_INPUT_FORMAT;
import static org.junit.jupiter.api.Assertions.*;

import calculator.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private InputView inputView;
    private Calculator calculator;

    @BeforeEach
    void setup () {
        inputView = new InputView();
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
    @DisplayName("빈 문자열을 입력했을 경우 에러를 반환하지 않는다.")
    void BlankInputNoException () {
        // given
        String input = BLANK_INPUT;

        // when & then\
        assertDoesNotThrow(() -> calculator.handleInput(input));
    }

    @Test
    @DisplayName("커스텀 문자열을 입력했을 경우 에러를 반환하지 않는다.")
    void InputCustomSeparatorNoException () {
        // given
        String input = INPUT_CUSTOM_SEPARATOR;

        // when & then\
        assertDoesNotThrow(() -> calculator.handleInput(input));
    }

    @Test
    @DisplayName("빈 문자열을 입력했을 경우 에러를 반환하지 않는다.")
    void InputStartNumberNoException () {
        // given
        String input = INPUT_START_NUMBER;

        // when & then\
        assertDoesNotThrow(() -> calculator.handleInput(input));
    }

}