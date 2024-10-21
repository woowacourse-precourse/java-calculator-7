package calculator.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DelimiterTest {

    private static final String COLON = ":";
    private static final String COMMA = ",";
    private Delimiter delimiter;

    @BeforeEach
    void setUp() {
        delimiter = new Delimiter();
    }

    @Test
    void 기본_구분자를_사용할_수_있다() {
        String expression = "1:2:3";

        delimiter.choose(expression);

        assertTrue(delimiter.concatDelimiters().contains(":"));
    }

    @Test
    void 커스텀_구분자를_사용할_수_있다() {
        String expression = "//k\\n1k2k3";

        delimiter.choose(expression);

        assertTrue(delimiter.concatDelimiters().contains("k"));
    }
}
