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

        int result1 = Integer.parseInt(calculator.calculate(input1));
        int result2 = Integer.parseInt(calculator.calculate(input2));
        int result3 = Integer.parseInt(calculator.calculate(input3));
        int result4 = Integer.parseInt(calculator.calculate(input4));
        //then
        Assertions.assertEquals(6,result1);
        Assertions.assertEquals(6,result2);
        Assertions.assertEquals(6,result3);
        Assertions.assertEquals(6,result4);
    }

    @Test
    void 자릿수에따른덧셈(){
        //given
        String input1 = "1,2,3";
        String input2 = "10,20,30";
        String input3 = "100,200,300";
        String input4 = "1000,2000,3000";
        String decimalInput = "0.11,0.22,0.33";
        //when
        int result1 = Integer.parseInt(calculator.calculate(input1));
        int result2 = Integer.parseInt(calculator.calculate(input2));
        int result3 = Integer.parseInt(calculator.calculate(input3));
        int result4 = Integer.parseInt(calculator.calculate(input4));
        Double result5 = Double.parseDouble(calculator.calculate(decimalInput));
        //then
        Assertions.assertEquals(6,result1);
        Assertions.assertEquals(60,result2);
        Assertions.assertEquals(600,result3);
        Assertions.assertEquals(6000,result4);
        Assertions.assertEquals(0.66,result5);
    }




}
