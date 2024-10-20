package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PatternParserTest {

    private final PatternParser patternParser = new PatternParser();

    @Test
    public void testSplitPattern() throws Exception {
        //given
        String input1 = "//;\\n1;2;3";
        String input2 = "1,2:7,4fg:34";

        //when
        String[] result1 = patternParser.splitPattern(input1);
        String[] result2 = patternParser.splitPattern(input2);

        //then
        String[] valid1 = {"//", "\\n1", "2", "3"};
        String[] valid2 = {"1", "2", "7", "4fg", "34"};
        assertArrayEquals(valid1, result1);
        assertArrayEquals(valid2, result2);
    }

    @Test
    public void testIsCustomPattern() throws Exception {
        //given
        String input1 = "//;\\n1;2;3";
        String input2 = "1,2:3";

        //when
        boolean result1 = patternParser.isCustomPattern(input1);
        boolean result2 = patternParser.isCustomPattern(input2);

        //then
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    public void testIsReservePattern() throws Exception {
        //given
        String input1 = "1,2:3";
        String input2 = "//;\\n1;2;3";

        //when
        boolean result1 = patternParser.isReservePattern(input1);
        boolean result2 = patternParser.isReservePattern(input2);

        //then
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    public void testParseCustomPattern() throws Exception {
        //given
        String input1 = "//;\\n1;2;3";
        String input2 = "//oo\\n1oo2oo3";

        //when
        String result1 = patternParser.parseCustomPattern(input1);
        String result2 = patternParser.parseCustomPattern(input2);

        //then
        assertEquals(";", result1);
        assertEquals("oo", result2);
    }

    @Test
    public void testValidationPattern() throws Exception {
        //given
        String input1 = "1,2:3";
        String input2 = "//;\\n1;2;3";

        //when, then
        assertTrue(patternParser.validatePattern(input1));
        assertTrue(patternParser.validatePattern(input2));
    }

    @Test
    public void testExceptionValidationPattern() throws Exception {
        //given
        String input1 = "asdasd";
        String input2 = "";

        //when, then
        assertThrows(IllegalArgumentException.class, ()
                -> patternParser.validatePattern(input1)
        );
        assertThrows(IllegalArgumentException.class, ()
                -> patternParser.validatePattern(input2)
        );
    }
}
