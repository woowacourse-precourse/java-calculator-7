package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    void validateIfInputNegative() {
        //given
        String input = "1,-2:3";
        List<Integer> numbersAfterParsing = DelimiterParser.getNumbersAfterParsing(input);
        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateIfInputNegative(numbersAfterParsing);
        });
    }
    @Test
    void validateIfInputNotNumber() {
        //given
        String input = "1@2#3";
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateIfInputNotNumber(input);
        });
    }
}