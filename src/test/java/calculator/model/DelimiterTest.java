package calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DelimiterTest {

    private Delimiter delimiter;

    @BeforeEach
    void setUp() {
        delimiter = new Delimiter();
    }

    @Test
    void 기본_구분자를_사용할_수_있다() {
        String expression = "1:2:3";

        delimiter.chooseFrom(expression);

        assertTrue(delimiter.getRegex().contains(":"));
    }

    @Test
    void 커스텀_구분자를_사용할_수_있다() {
        String expression = "//k\\n1k2k3";

        delimiter.chooseFrom(expression);

        assertTrue(delimiter.getRegex().contains("k"));
    }

    @Test
    void 커스텀_구분자의_전처리를_할_수_있다() {
        String expression = "//;\\n1;2;3";

        String removed = delimiter.removeAffix(expression);

        assertEquals("1;2;3", removed);
    }
}
