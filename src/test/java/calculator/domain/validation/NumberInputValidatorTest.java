package calculator.domain.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberInputValidatorTest {

    NumberInputValidator validator = new NumberInputValidator();

    @Test
    @DisplayName("숫자가 아닌 값이 섞여있으면 예외를 발생")
    void throws_when_is_not_numeric() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateOnlyNumeric("878*"));
    }
}
