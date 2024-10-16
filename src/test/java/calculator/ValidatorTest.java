package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    void validateIfInputNegative() {
        //given
        String number = "-1";
        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateIfInputNotNumber(number);
        });
    }
    @Test
    void validateIfInputNotNumber() {
        //given
        String number = "a";
        //when //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateIfInputNotNumber(number);
        });
    }
}