package calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NumberParserTest {
    private final NumberParser numberParser = new NumberParser();

    @Test
    public void testReplaceNumber() throws Exception{
        //given
        String[] inputArr = {"sfd2", "33", "*&34fgf", "v3ds1*$^4"};

        //when
        String[] result = numberParser.replaceNumber(inputArr);

        //then
        String[] valid = {"2","33","34","314"};
        String[] invalid = {"2","33","34","14"};
        assertArrayEquals(valid, result);
        assertNotEquals(invalid, result);
    }

}
