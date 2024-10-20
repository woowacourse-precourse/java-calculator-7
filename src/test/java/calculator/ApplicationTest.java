package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationTest {

    @Test
    public void testEmptyInput() {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void testBasicInput() {
        assertEquals(3, Calculator.add("1,2"));
        assertEquals(6, Calculator.add("1,2,3"));
        assertEquals(6, Calculator.add("1,2:3"));
    }

    @Test
    public void testCustomDelimiter() {
        assertEquals(6, Calculator.add("//;\n1;2;3"));
        assertEquals(10, Calculator.add("//#\n4#5#1"));
    }

    @Test
    public void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.add("1,2,3,a"));
        assertThrows(IllegalArgumentException.class, () -> Calculator.add("1,2:-3"));
        assertThrows(IllegalArgumentException.class, () -> Calculator.add("//;\n1;2;3;a"));
        assertThrows(IllegalArgumentException.class, () -> Calculator.add("//;\n1;2;3,4"));
    }

    @Test
    public void testNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.add("1,-2,3"));
    }
}
