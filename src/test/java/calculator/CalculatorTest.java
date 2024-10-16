package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();
    @Test
    void 기본구분자입력(){
        //given
        String input1 = "1,2,3";
        String input2 = "1,,2,,3";
        String input3 = "1:2:3";
        String input4 = "1::2::3";
        //when

        int result1 = calculator.calculate(input1);
        int result2 = calculator.calculate(input2);
        int result3 = calculator.calculate(input3);
        int result4 = calculator.calculate(input4);
        //then
        Assertions.assertEquals(6,result1);
        Assertions.assertEquals(6,result2);
        Assertions.assertEquals(6,result3);
        Assertions.assertEquals(6,result4);
    }

}
