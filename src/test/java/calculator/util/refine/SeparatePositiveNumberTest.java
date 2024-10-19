package calculator.util.refine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.util.exception.CalculatorValidationException.validateEmptyInputException;
import calculator.util.exception.CalculatorValidationException.validateIsIntegerException;
import calculator.util.exception.CalculatorValidationException.validateNonNegativeNumberException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SeparatePositiveNumberTest {

    private SeparatePositiveNumber separatePositiveNumber;

    @BeforeEach
    void setUp() {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        separatePositiveNumber = new SeparatePositiveNumber(delimiterExtractor);
    }

    @Test
    void extractNumbers_basic_delimiter_normal_operation_test() {
        String input = "1,2:3";
        List<Integer> numbers = separatePositiveNumber.extractNumbers(input);
        assertEquals(List.of(1, 2, 3), numbers);
    }

    @Test
    void extractNumbers_custom_delimiter_normal_operation_test() {
        String input = "//;\\n1;2;3";
        List<Integer> numbers = separatePositiveNumber.extractNumbers(input);
        assertEquals(List.of(1, 2, 3), numbers);
    }

    @Test
    void extractNumbers_negativeNumber_exception_test() {
        String input = "1,-2:3";
        assertThrows(validateNonNegativeNumberException.class, () -> {
            separatePositiveNumber.extractNumbers(input);
        });
    }

    @Test
    void extractNumbers_empty_expression_exception_test() {
        String input = "";
        assertThrows(validateEmptyInputException.class, () -> {
            separatePositiveNumber.extractNumbers(input);
        });
    }

    @Test
    void extractNumbers_non_integer_value_exception_test() {
        String input = "1,a:3";
        assertThrows(validateIsIntegerException.class, () -> {
            separatePositiveNumber.extractNumbers(input);
        });
    }
}