package calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PatternParserTest {

    private final PatternParser patternParser = new PatternParser();

    @Test
    public void testIsCustomPattern_validCustomPattern() throws Exception{
        //given
        String input = "//;\n1;2;3";

        //when
        boolean result = patternParser.isCustomPattern(input);

        //then
        assertTrue(result);
    }

    @Test void testIsCustomPattern_invalidCustomPattern() throws Exception{
        //given
        String input = "1,2:3";

        //when
        boolean result = patternParser.isCustomPattern(input);

        //then
        assertFalse(result);
    }
}
