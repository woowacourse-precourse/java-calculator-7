package calculator;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.domain.Calculator;
import calculator.validators.Validators;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ValidatorTest {

    private Validators validators;
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        validators = new Validators();
        calculator = new Calculator();
        calculator.init();
    }

    @Test
    void testValidateDelimiterDeclaration_Success_True() {
        assertTrue(validators.validateDelimiterDeclaration("//;\\n1;2"));
    }

    @Test
    void testValidateDelimiterDeclaration_Success_False() {
        assertFalse(validators.validateDelimiterDeclaration("1:2"));
    }

    @Test
    void testValidateDelimiterDeclaration_Fail_NoNewLine() {
        assertThrows(IllegalArgumentException.class, () -> validators.validateDelimiterDeclaration("//;1;2"));
    }

    @Test
    void testValidateAllowedCharacters_Success() {
        validators.validateAllowedCharacters(Arrays.asList(':', ','), "1:2,3");
    }

    @Test
    void testValidateAllowedCharacters_Fail_InvalidCharacter() {
        assertThrows(IllegalArgumentException.class,
                () -> validators.validateAllowedCharacters(Arrays.asList(':', ','), "1;2,3"));
    }

    @Test
    void testValidateDelimiterSurroundings_Success() {
        validators.validateDelimiterSurroundings(calculator, "1:2:3");
    }

    @Test
    void testValidateDelimiterSurroundings_Fail_EmptySection() {
        assertThrows(IllegalArgumentException.class,
                () -> validators.validateDelimiterSurroundings(calculator, "1::2"));
    }
}
