package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ValidatorTest {
    @Test
    void validateIfNotNumberIfInputNegative() {
        //given
        String input = "1,-2:3";
        List<Integer> numbersAfterParsing = DelimiterParser.getNumbersAfterParsing(input);
        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateIfInputNegative(numbersAfterParsing);
        });
    }
    @Test
    void validateIfNotNumber() {
        //given
        String input = "1@2#3";
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateIfNotNumber(input);
        });
    }
}