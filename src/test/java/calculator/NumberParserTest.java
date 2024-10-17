package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NumberParserTest {
    private final NumberParser numberParser = new NumberParser();

    @Test
    public void testReplaceNumber() throws Exception {
        //given
        String[] inputArr = {"sfd2", "33", "*&34fgf", "v3ds1*$^4"};

        //when
        String[] result = numberParser.replaceNumber(inputArr);

        //then
        String[] valid = {"2", "33", "34", "314"};
        String[] invalid = {"2", "33", "34", "14"};
        assertArrayEquals(valid, result);
        assertNotEquals(invalid, result);
    }

    @Test
    public void testReplaceNumberNegative() throws Exception {
        //given
        String[] inputArr = {"-2", "33", "*&", "v3d^4"};

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            numberParser.replaceNumber(inputArr);
        }, "success");
    }

    @Test
    public void testSumNumber() throws Exception {
        //given
        String[] inputArr = {"3", "45", "2"};

        //when
        int result = numberParser.sumNumber(inputArr);

        //then
        assertEquals(50, result);
    }

    @Test
    public void testCheckNegative() throws Exception {
        //given
        String input = "-1";

        //when
        boolean result = numberParser.checkNegative(input);

        //then
        assertTrue(result);
    }
}
