package calculator.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class CalculatorServiceImplTest {

    private CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();;

    @Test
    void simpleCalculateTest() {
        BigInteger[] numbers = {BigInteger.ONE, BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(4), BigInteger.valueOf(5)};
        BigInteger result = calculatorService.calculate(numbers);
        assertEquals(BigInteger.valueOf(15), result);
    }

    @Test
    void emptyArrayCalculateTest() {
        BigInteger[] numbers = {};
        BigInteger result = calculatorService.calculate(numbers);
        assertEquals(BigInteger.ZERO, result);
    }

    @Test
    void negativeNumbersArrayCalculateTest() {
        BigInteger[] numbers = {BigInteger.valueOf(-1), BigInteger.valueOf(-2), BigInteger.valueOf(-3), BigInteger.valueOf(-4)};
        BigInteger result = calculatorService.calculate(numbers);
        assertEquals(BigInteger.valueOf(-10), result);
    }

    @Test
    void onlyZeroArrayCalculateTest() {
        BigInteger[] numbers = {BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO};
        BigInteger result = calculatorService.calculate(numbers);
        assertEquals(BigInteger.ZERO, result);
    }

    @Test
    void mixedPositiveAndNegativeNumbersArrayCalculateTest() {
        BigInteger[] numbers = {BigInteger.valueOf(1), BigInteger.valueOf(-2), BigInteger.valueOf(3), BigInteger.valueOf(-4), BigInteger.valueOf(5)};
        BigInteger result = calculatorService.calculate(numbers);
        assertEquals(BigInteger.valueOf(3), result);
    }
}