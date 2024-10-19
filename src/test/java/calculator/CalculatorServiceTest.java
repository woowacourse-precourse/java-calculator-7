package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    public static final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testCalcualte() throws Exception {
        //given
        String input1 = "a1,2:3";
        String input2 = "//;\\n1;2;4";
        String input3 = "sdf.34.df11";

        //when
        int result1 = calculatorService.calculate(input1);
        int result2 = calculatorService.calculate(input2);
        int result3 = calculatorService.calculate(input3);

        //then
        Assertions.assertEquals(result1, 6);
        Assertions.assertEquals(result2, 7);
        Assertions.assertEquals(result3, 0);
    }
}