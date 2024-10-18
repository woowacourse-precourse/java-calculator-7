package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void validateIfInputNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateIfInputNegative(-1);
        });
    }
    @Test
    void validateIfNotNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateIfNotNumber("@");
        });
    }

}