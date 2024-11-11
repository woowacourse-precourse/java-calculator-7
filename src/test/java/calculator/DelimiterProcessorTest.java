package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DelimiterProcessorTest {

    private final DelimiterProcessor delimiterProcessor = new DelimiterProcessor();

    @Test
    void testProcessWithDefaultDelimiters() {
        String[] result = delimiterProcessor.process("1,2:3");
        assertArrayEquals(new String[] {"1", "2", "3"}, result);
    }

    @Test
    void testProcessWithCustomDelimiter() {
        String[] result = delimiterProcessor.process("//;\n1;2;3");
        assertArrayEquals(new String[] {"1", "2", "3"}, result);
    }

    @Test
    void testProcessWithDifferentCustomDelimiter() {
        String[] result = delimiterProcessor.process("//|\n1|2|3");
        assertArrayEquals(new String[] {"1", "2", "3"}, result);
    }

    @Test
    void testProcessWithoutNumbers() {
        String[] result = delimiterProcessor.process("//;\n");
        assertArrayEquals(new String[] {""}, result);
    }
}