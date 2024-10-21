package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringParserTest {

    @Test
    void 입력값의_개행문자를_줄바꿈으로_치환한다() {
        String input = "//;\\n1";
        String parsedInput = StringParser.parseBr(input);

        assertEquals(2, parsedInput.split("\n").length);
    }
}
