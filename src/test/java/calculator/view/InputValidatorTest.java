package calculator.view;

import calculator.view.InputValidator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {
    @Test
    void testValidatingSeparator_validSeparator() {
        InputValidator validator = new InputValidator();
        List<String> separated = Arrays.asList("1", ",", "2", ":", "3");
        validator.validatingSeparator(separated, Arrays.asList(",", ":"));
    }

    @Test
    void testValidatingSeparator_invalidSeparator() {
        InputValidator validator = new InputValidator();
        List<String> separated = Arrays.asList("1", "&", "2");
        assertThrows(IllegalArgumentException.class, () ->
                validator.validatingSeparator(separated, Arrays.asList(",", ":"))
        );
    }

    @Test
    void testLastElement_validLastElement() {
        InputValidator validator = new InputValidator();
        List<String> separated = Arrays.asList("1", ",", "2", ":", "3");
        validator.lastElement(separated);
    }

    @Test
    void testLastElement_invalidLastElement() {
        InputValidator validator = new InputValidator();
        List<String> separated = Arrays.asList("1", ",", "2", ":", ":");
        assertThrows(IllegalArgumentException.class, () ->
                validator.lastElement(separated)
        );
    }

    @Test
    void testValidatingFirstLetter_valid() {
        InputValidator validator = new InputValidator();
        validator.validatingFirstLetter('/');
        validator.validatingFirstLetter('1');
    }

    @Test
    void testValidatingFirstLetter_invalid() {
        InputValidator validator = new InputValidator();
        assertThrows(IllegalArgumentException.class, () ->
                validator.validatingFirstLetter('a')
        );
    }

    @Test
    void testCustomValidator_valid() {
        InputValidator validator = new InputValidator();
        String separator = validator.customValidator("//;\n1;2");
        assertEquals(";", separator);
    }

    @Test
    void testCustomValidator_invalidForm() {
        InputValidator validator = new InputValidator();
        assertThrows(IllegalArgumentException.class, () ->
                validator.customValidator("1;2")
        );
    }

    @Test
    void testCustomValidator_invalidContent() {
        InputValidator validator = new InputValidator();
        assertThrows(IllegalArgumentException.class, () ->
                validator.customValidator("//1\n1;2")
        );
    }
}
