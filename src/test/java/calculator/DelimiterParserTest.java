package calculator;

import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DelimiterParserTest {
    private final DelimiterParser parser = new DelimiterParser();
    private final String DEFAULT_DELIMITER = "[,:]";

    @Test
    void 정상동작_테스트() {
        String customDelimiter = ";";
        String content = "1,2:3";

        DelimiterContentPair result = parser.parseInput("//" + customDelimiter + "\n" + content);

        assertEquals(content, result.getContent());
        assertEquals(DEFAULT_DELIMITER + "|" + Pattern.quote(customDelimiter), result.getDelimiter());
    }

    @Test
    void 개행문자X_예외_테스트() {
        String customDelimiter = ";";
        String content = "1,2:3";

        assertThrows(IllegalArgumentException.class,
                () -> parser.parseInput("//" + customDelimiter + content));
    }

    @Test
    void 커스텀구분자X_예외_테스트() {
        String content = "1,2:3";

        assertThrows(IllegalArgumentException.class,
                () -> parser.parseInput("//" + "\n" + content));
    }
}
