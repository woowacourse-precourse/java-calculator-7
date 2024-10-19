package calculator.util.refine;

import static calculator.util.exception.CalculatorValidationException.validateDelimiterAfterNewLinePresenceException;
import static calculator.util.exception.CalculatorValidationException.validateEmptyInputException;
import static calculator.util.exception.CalculatorValidationException.validateIsIntegerException;
import static calculator.util.exception.CalculatorValidationException.validateNonNegativeNumberException;
import static calculator.util.exception.CalculatorValidationException.validateSingleCharacterDelimiterException;
import static calculator.util.refine.InputValidator.validateDelimiterAfterNewLinePresence;
import static calculator.util.refine.InputValidator.validateIsEmptyInput;
import static calculator.util.refine.InputValidator.validateIsInteger;
import static calculator.util.refine.InputValidator.validateNonNegativeNumber;
import static calculator.util.refine.InputValidator.validateSingleCharacterDelimiter;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void validateDelimiterAfterNewLinePresence_정상_동작() {
        validateDelimiterAfterNewLinePresence(5);
    }

    @Test
    void validateDelimiterAfterNewLinePresence_예외_발생() {
        assertThrows(validateDelimiterAfterNewLinePresenceException.class,
                () -> validateDelimiterAfterNewLinePresence(-1));
    }

    @Test
    void validateNonNegativeNumber_정상_동작() {
        validateNonNegativeNumber(10);
    }

    @Test
    void validateNonNegativeNumber_예외_발생() {
        assertThrows(validateNonNegativeNumberException.class,
                () -> validateNonNegativeNumber(-4));
    }

    @Test
    void validateSingleCharacterDelimiter_정상_동작() {
        validateSingleCharacterDelimiter(";");
    }

    @Test
    void validateSingleCharacterDelimiter_예외_발생() {
        assertThrows(validateSingleCharacterDelimiterException.class,
                () -> validateSingleCharacterDelimiter(";;"));
    }

    @Test
    void validateIsInteger_정상_동작() {
        validateIsInteger("123");
    }

    @Test
    void validateIsInteger_예외_발생() {
        assertThrows(validateIsIntegerException.class,
                () -> validateIsInteger("abc"));
    }

    @Test
    void validateIsEmptyInput_정상_동작() {
        validateIsEmptyInput("1,2,3");
    }

    @Test
    void validateIsEmptyInput_예외_발생() {
        assertThrows(validateEmptyInputException.class,
                () -> validateIsEmptyInput(""));
    }
}