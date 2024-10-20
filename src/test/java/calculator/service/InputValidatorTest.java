package calculator.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
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
}