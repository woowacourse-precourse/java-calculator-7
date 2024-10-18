package calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    @Test
    @DisplayName("음수가 포함되어 있을 경우")
    void 양수_검증_1() {
        String[] numbers = new String[]{"1", "-2", "4"};
        NumberValidator numberValidator = NumberValidator.getInstance();
        Assertions.assertThrows(IllegalArgumentException.class, () -> numberValidator.validatePositiveNumbers(numbers));
    }

    @Test
    @DisplayName("문자가 포함되어 있을 경우")
    void 양수_검증_2() {
        String[] numbers = new String[]{"1", "aa", "4"};
        NumberValidator numberValidator = NumberValidator.getInstance();
        Assertions.assertThrows(IllegalArgumentException.class, () -> numberValidator.validatePositiveNumbers(numbers));
    }
}