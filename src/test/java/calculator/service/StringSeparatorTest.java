package calculator.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.domain.Calculator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StringSeparatorTest {

    @Test
    public void 구분자_추출() {
        Calculator calculator = new Calculator();
        StringSeparator stringSeparator = new StringSeparator(calculator);

        String separator = stringSeparator.extractionSeparator("//]\n");
        assertTrue(separator.equals("]"));
    }

    @Test
    public void 구분자_커스텀() {
        Calculator calculator = new Calculator();
        StringSeparator stringSeparator = new StringSeparator(calculator);

        String separator = stringSeparator.extractionSeparator("//]\n");
        calculator.addSeparator(separator);

        List<String> separators = calculator.getSeparators();
        assertTrue(separators.contains("]"));
    }
}
