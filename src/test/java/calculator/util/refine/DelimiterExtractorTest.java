package calculator.util.refine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.util.exception.CalculatorValidationException.validateSingleCharacterDelimiterException;
import org.junit.jupiter.api.Test;

class DelimiterExtractorTest {

    private final DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

    @Test
    void extractDelimiter_basic_delimiter_test() {
        String input = "1,2:3";
        String delimiter = delimiterExtractor.extractDelimiter(input);
        assertEquals("[,:]", delimiter);
    }

    @Test
    void extractDelimiter_custom_delimiter_test() {
        String input = "//;\\n1;2;3";
        String delimiter = delimiterExtractor.extractDelimiter(input);
        assertEquals(";", delimiter);
    }

    @Test
    void extractDelimiter_invalid_delimiter_exception_test() {
        String input = "//;;\\n1;2;3";
        assertThrows(validateSingleCharacterDelimiterException.class,
                () -> {
                    delimiterExtractor.extractDelimiter(input);
                });
    }

    @Test
    void removeDelimiterDefinition_custom_delimiter_remove_test() {
        String input = "//;\\n1;2;3";
        String refineInput = delimiterExtractor.removeDelimiterDefinition(input);
        assertEquals("1;2;3", refineInput);
    }

    @Test
    void removeDelimiterDefinition_basic_input_test() {
        String input = "1,2:3";
        String refinedInput = delimiterExtractor.removeDelimiterDefinition(input);
        assertEquals(input, refinedInput);
    }
}