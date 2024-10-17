package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PatternParserTest {

    private final PatternParser patternParser = new PatternParser();

    @Test
    public void testValidIsCustomPattern() throws Exception {
        //given
        String input = "//;\\n1;2;3";

        //when
        boolean result = patternParser.isCustomPattern(input);

        //then
        assertTrue(result);
    }

    @Test
    void testInvalidIsCustomPattern() throws Exception {
        //given
        String input = "1,2:3";

        //when
        boolean result = patternParser.isCustomPattern(input);

        //then
        assertFalse(result);
    }

    @Test
    public void testValidIsReservePattern() throws Exception {
        //given
        String input = "1,2:3";

        //when
        boolean result = patternParser.isReservePattern(input);

        //then
        assertTrue(result);

    }

    @Test
    public void testInvalidIsReservePattern() throws Exception {
        //given
        String input = "//;\n1;2;3";

        //when
        boolean result = patternParser.isReservePattern(input);

        //then
        assertFalse(result);
    }

    @Test
    public void testParseCustomPattern() throws Exception {
        //given
        String input = "//;\n1;2;3";

        //when
        String result = patternParser.parseCustomPattern(input);

        //then
        assertEquals(";", result);
    }

    @Test
    public void testCustomSplitPattern() throws Exception {
        //given
        String input = "//;\n1;2;3";

        //when
        String[] result = patternParser.splitPattern(input);

        //then
        String[] valid = {"1", "2", "3"};
        assertArrayEquals(valid, result);
    }

    @Test
    public void testReserveSplitPattern() throws Exception {
        //given
        String input = "1,2:3";

        //when
        String[] result = patternParser.splitPattern(input);

        //then
        String[] valid = {"1", "2", "3"};
        assertArrayEquals(valid, result);
    }

    @Test
    public void testNotSplitPattern() throws Exception {
        //given
        String input = "1*23(4)54";

        //when
        String[] result = patternParser.splitPattern(input);

        //then
        String[] valid = {};
        assertArrayEquals(valid, result);
    }
}
