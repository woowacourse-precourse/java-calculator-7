package calculator.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void isEmptyInput() {
        // given
        InputValidator inputValidator = new InputValidator();

        // when
        Boolean resultTrue = inputValidator.isEmptyInput("");
        Boolean resultFalse = inputValidator.isEmptyInput("1:2:3");

        // then
        assertTrue(resultTrue);
        assertFalse(resultFalse);
    }

    @Test
    void isStartOrEndWithWord() {

        // given
        InputValidator inputValidator = new InputValidator();

        // when
        Boolean startWithResult = inputValidator.isStartOrEndWithWord(",1,2,3");
        Boolean endWitchResult = inputValidator.isStartOrEndWithWord("1,2,3,");
        Boolean correctInputResult = inputValidator.isStartOrEndWithWord("1:2:3");

        // then
        assertTrue(startWithResult);
        assertTrue(endWitchResult);
        assertFalse(correctInputResult);

    }
}