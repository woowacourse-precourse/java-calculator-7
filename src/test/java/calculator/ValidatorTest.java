package calculator;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.validators.Validators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ValidatorTest {

    private Validators validators;

    @BeforeEach
    void setUp() {
        validators = new Validators();
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

    
}
