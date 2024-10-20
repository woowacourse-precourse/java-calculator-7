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
    public void testRemoveNonDigits() throws Exception {
        //given
        String[] inputArr = {"sfd2", "33", "*&34fgf", "v3ds1*$^4"};

        //when
        String[] result = numberParser.removeNonDigits(inputArr);

        //then
        String[] valid = {"2", "33", "34", "314"};
        String[] invalid = {"2", "33", "34", "14"};
        assertArrayEquals(valid, result);
        assertNotEquals(invalid, result);
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
        String[] inputArr1 = {"1", "4", "6"};
        String[] inputArr2 = {"-1", "4", "6"};

        //when
        boolean result1 = numberParser.checkNegative(inputArr1);

        //then
        assertTrue(result1);
        assertThrows(IllegalArgumentException.class, () -> {
            numberParser.checkNegative(inputArr2);
        });
    }
}
