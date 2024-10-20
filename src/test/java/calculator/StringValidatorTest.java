package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringValidatorTest {
    StringValidator stringValidator =new StringValidator();

    @Test
    void validateNegativeNumberTest() {
        String[] invalidInput1 = {"-1","2","3"};
        String[] invalidInput2 = {"1","-1","3"};
        String[] invalidInput3 = {"1","2","-3"};

        assertThrows(IllegalArgumentException.class, () -> {
            stringValidator.validateNegativeNumber(invalidInput1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            stringValidator.validateNegativeNumber(invalidInput2);
        }); assertThrows(IllegalArgumentException.class, () -> {
            stringValidator.validateNegativeNumber(invalidInput3);
        });
    }

    @Test
    void validateStringTest() {
        String[] invalidInput1 = {"a","2","3"};
        String[] invalidInput2 = {"1","a","3"};
        String[] invalidInput3 = {"1","2","a"};
        String[] invalidInput4 = {" "," "," "};

        assertThrows(IllegalArgumentException.class, () -> {
            stringValidator.validateString(invalidInput1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            stringValidator.validateString(invalidInput2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            stringValidator.validateString(invalidInput3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            stringValidator.validateString(invalidInput4);
        });
    }
}