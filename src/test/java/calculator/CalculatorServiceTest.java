package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    public static final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testSplitInput() throws Exception {
        //given
        String input1 = "a1,2:3";
        String input2 = "//;\\n1;2;3";
        String input3 = "sdf.34.df11";

        //when
        String[] splitInput1 = calculatorService.splitInput(input1);
        String[] splitInput2 = calculatorService.splitInput(input2);
        String[] splitInput3 = calculatorService.splitInput(input3);

        String[] result1 = {"a1", "2", "3"};
        String[] result2 = {"//", "\\n1", "2", "3"};
        String[] result3 = new String[0];

        // then
        Assertions.assertArrayEquals(result1, splitInput1);
        Assertions.assertArrayEquals(result2, splitInput2);
        Assertions.assertArrayEquals(result3, splitInput3);
    }

    @Test
    public void testReplaceNumber() throws Exception {
        //given
        String[] input1 = {"a1", "2", "3"};
        String[] input2 = {"//", "\\n1", "2", "3"};
        String[] input3 = new String[0];

        //when
        String[] splitInput1 = calculatorService.replaceNumber(input1);
        String[] splitInput2 = calculatorService.replaceNumber(input2);
        String[] splitInput3 = calculatorService.replaceNumber(input3);

        String[] result1 = {"1", "2", "3"};
        String[] result2 = {"", "1", "2", "3"};
        String[] result3 = new String[0];

        //then
        Assertions.assertArrayEquals(result1, splitInput1);
        Assertions.assertArrayEquals(result2, splitInput2);
        Assertions.assertArrayEquals(result3, splitInput3);
    }

    @Test
    public void testSumNumber() throws Exception {
        //given
        String[] input1 = {"1", "2", "3"};
        String[] input2 = {"", "1", "2", "4"};
        String[] input3 = new String[0];
        //when
        int splitNumberInput1 = calculatorService.sumNumber(input1);
        int splitNumberInput2 = calculatorService.sumNumber(input2);
        int splitNumberInput3 = calculatorService.sumNumber(input3);

        int result1 = 6;
        int result2 = 7;
        int result3 = 0;

        //then
        Assertions.assertEquals(result1, splitNumberInput1);
        Assertions.assertEquals(result2, splitNumberInput2);
        Assertions.assertEquals(result3, splitNumberInput3);
    }
}
