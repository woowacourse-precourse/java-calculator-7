package calculator.service.impl;

import static calculator.common.InputStatus.CUSTOM_DELIMITER_STATUS;
import static calculator.common.InputStatus.DEFAULT_DELIMITERS_STATUS;
import static calculator.common.InputStatus.EMPTY_CUSTOM_DELIMITER_STATUS;
import static org.junit.jupiter.api.Assertions.*;

import calculator.common.InputStatus;
import org.junit.jupiter.api.Test;

class ValidatorServiceImplTest {

    private final ValidatorServiceImpl validatorService = new ValidatorServiceImpl();
    private final ExtractorServiceImpl extractorService = new ExtractorServiceImpl(validatorService);

    @Test
    public void testCustomDelimiter() {
        String input = "//;\\n1;2;3";
        InputStatus status = validatorService.validateInput(input);
        assertEquals(CUSTOM_DELIMITER_STATUS, status);
    }

    @Test
    public void testEmptyCustomDelimiter() {
        String input = "//\\n1,2,3";
        InputStatus status = validatorService.validateInput(input);
        assertEquals(EMPTY_CUSTOM_DELIMITER_STATUS, status);
    }

    @Test
    public void testDefaultDelimiters() {
        String input = "1,2,3";
        InputStatus status = validatorService.validateInput(input);
        assertEquals(DEFAULT_DELIMITERS_STATUS, status);
    }

    @Test
    public void testInvalidFormat() {
        String input = "//;1;2;3";
        assertThrows(IllegalArgumentException.class, () -> {
            validatorService.validateInput(input);
        });
    }

    @Test
    public void testValidDelimiter() {
        String delimiter = extractorService.extractCustomDelimiter("//;\\n");
        String expression = "1;2;3";
        assertDoesNotThrow(() -> {
            validatorService.validateDelimiterExpression(delimiter, expression);
        });
    }

    @Test
    public void testInvalidStartsWithDelimiter() {
        String delimiter = extractorService.extractCustomDelimiter("//;\\n");
        String expression = ";1;2;3";
        assertThrows(IllegalArgumentException.class, () -> {
            validatorService.validateDelimiterExpression(delimiter, expression);
        });
    }

    @Test
    public void testInvalidEndsWithDelimiter() {
        String delimiter = extractorService.extractCustomDelimiter("//;\\n");
        String expression = "1;2;3;";
        assertThrows(IllegalArgumentException.class, () -> {
            validatorService.validateDelimiterExpression(delimiter, expression);
        });
    }

    @Test
    public void testInvalidConsecutiveDelimiters() {
        String delimiter = extractorService.extractCustomDelimiter("//;\\n");
        String expression = "1;;2;3";
        assertThrows(IllegalArgumentException.class, () -> {
            validatorService.validateDelimiterExpression(delimiter, expression);
        });
    }

    @Test
    public void testInvalidNegativeNumbers() {
        String delimiter = extractorService.extractCustomDelimiter("//;\\n");
        String expression = "1;-2;3";
        assertThrows(IllegalArgumentException.class, () -> {
            validatorService.validateDelimiterExpression(delimiter, expression);
        });
    }

    @Test
    public void testInvalidNumericDelimiter() {
        String delimiter = extractorService.extractCustomDelimiter("//1\\n");
        String expression = "1;2;3";
        assertThrows(IllegalArgumentException.class, () -> {
            validatorService.validateDelimiterExpression(delimiter, expression);
        });
    }
}