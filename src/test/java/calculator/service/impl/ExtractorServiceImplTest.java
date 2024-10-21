package calculator.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import calculator.model.Operand;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class ExtractorServiceImplTest {
    private final ValidatorServiceImpl validatorService = new ValidatorServiceImpl();
    private final ExtractorServiceImpl extractorService = new ExtractorServiceImpl(validatorService);

    @Test
    void testDefaultDelimiters() {
        String input = "1,2:3";
        Operand operand = extractorService.extract(input);
        assertArrayEquals(new BigInteger[]{BigInteger.ONE, BigInteger.valueOf(2), BigInteger.valueOf(3)}, operand.getNumbers());
    }

    @Test
    void testEmptyCustomDelimiter() {
        String input = "//;\\n1,2;3";
        Operand operand = extractorService.extract(input);
        assertArrayEquals(new BigInteger[]{BigInteger.ONE, BigInteger.valueOf(2), BigInteger.valueOf(3)}, operand.getNumbers());
    }

    @Test
    void testCustomDelimiter() {
        String input = "//#\\n1#2#3";
        Operand operand = extractorService.extract(input);
        assertArrayEquals(new BigInteger[]{BigInteger.ONE, BigInteger.valueOf(2), BigInteger.valueOf(3)}, operand.getNumbers());
    }

    @Test
    void testCustomDelimiterContainingInvalidDelimiter() {
        String input = "//2;\\n1,2;3";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> extractorService.extract(input));
        assertEquals("Custom delimiter cannot be a number: 2", exception.getMessage());
    }

    @Test
    void testConsecutiveDelimiters() {
        String input = "//-\\n1--2-3";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> extractorService.extract(input));
        assertEquals("Consecutive delimiters are not allowed.", exception.getMessage());
    }

    @Test
    void testCustomAndDefaultDelimitersCombined() {
        String input = "//;\\n1;2,3:4";
        Operand operand = extractorService.extract(input);
        assertArrayEquals(new BigInteger[]{BigInteger.ONE, BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(4)}, operand.getNumbers());
    }

    @Test
    void testEmptyString() {
        String input = "";
        Operand operand = extractorService.extract(input);
        assertArrayEquals(new BigInteger[]{BigInteger.ZERO}, operand.getNumbers());
    }

    @Test
    void testCustomDelimiterInvalidNumbers() {
        String input = "//;\\n-1;2,3";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> extractorService.extract(input));
        assertEquals("Negative numbers are not allowed", exception.getMessage());
    }

    @Test
    void testLargeSum() {
        String input = "2147483648,2147483648";
        Operand operand = extractorService.extract(input);
        assertArrayEquals(new BigInteger[]{new BigInteger("2147483648"), new BigInteger("2147483648")}, operand.getNumbers());
    }
}