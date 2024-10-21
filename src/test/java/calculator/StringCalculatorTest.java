package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    @Test
    void test_defaultDelimiter() {
        //given
        StringCalculator calculator = new StringCalculator();
        String input = "1:2,3";
        //when
        int add = calculator.add(input);
        //then
        Assertions.assertEquals(6, add);
    }
    @Test
    void test_customDelimiter() {
        //given
        StringCalculator calculator = new StringCalculator();
        String input = "//;\\n1;2;3";
        //when
        int add = calculator.add(input);
        //then
        Assertions.assertEquals(6, add);
    }



}