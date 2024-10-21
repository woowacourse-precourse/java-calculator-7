package calculator.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperandTest {
    @Test
    void testEmptyExpression() {
        Operand operand = Operand.create(",", "");
        assertArrayEquals(new int[]{0}, operand.getNumbers());
    }

    @Test
    void testValidNumbersAndDefaultDelimiter() {
        Operand operand = Operand.create(",", "1,2,3");
        assertArrayEquals(new int[]{1, 2, 3}, operand.getNumbers());
    }

    @Test
    void testValidNumbersAndCustomDelimiter() {
        Operand operand = Operand.create(";", "1;2;3");
        assertArrayEquals(new int[]{1, 2, 3}, operand.getNumbers());
    }
}