package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator calculator = new Calculator();
    @Test
    void inputEmptyString() {
        assertEquals(0, calculator.calculator(""));
    }
    @Test
    void input_십의자리이상_덧셈() {
        //given
        String case1 = "10,20:30";
        String case2 = "101,202:303";
        String case3 = "1011,2022:3033";
        //when
        int result1 = calculator.calculator(case1);
        int result2 = calculator.calculator(case2);
        int result3 = calculator.calculator(case3);
        //then
        assertEquals(60, result1);
        assertEquals(606, result2);
        assertEquals(6066, result3);
    }
}