package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ValidatorTest {

    @Test
    void validateIfInputNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateIfInputNegative(List.of(1, -1, 1));
        });
    }

}