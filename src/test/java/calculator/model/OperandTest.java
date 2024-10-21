package calculator.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class OperandTest {
    @Test
    void testEmptyExpression() {
        Operand operand = Operand.create(",", "");
        assertArrayEquals(new BigInteger[]{BigInteger.ZERO}, operand.getNumbers());
    }

    @Test
    void testValidNumbersAndDefaultDelimiter() {
        Operand operand = Operand.create(",", "1,2,3");
        assertArrayEquals(new BigInteger[]{BigInteger.ONE, BigInteger.valueOf(2), BigInteger.valueOf(3)}, operand.getNumbers());
    }

    @Test
    void testValidNumbersAndCustomDelimiter() {
        Operand operand = Operand.create(";", "1;2;3");
        assertArrayEquals(new BigInteger[]{BigInteger.ONE, BigInteger.valueOf(2), BigInteger.valueOf(3)}, operand.getNumbers());
    }
}