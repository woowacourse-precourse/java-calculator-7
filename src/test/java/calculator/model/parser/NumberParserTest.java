package calculator.model.parser;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberParserTest {

    private NumberParser intParser;
    private NumberParser longParser;

    @BeforeEach
    void setUp() {
        intParser = new IntParser();
        longParser = new LongParser();
    }

    @Test
    void IntParser_정상적인_int_범위의_문자열은_true를_반환한다() {
        String[] validInput = {"100", "200", "0", "-50", Integer.MAX_VALUE + "", Integer.MIN_VALUE + ""};

        boolean result = intParser.canParse(validInput);

        assertTrue(result);
    }

    @Test
    void IntParser_비정상적인_int_범위의_문자열은_false를_반환한다() {
        String[] invalidInput = {"100", "200", "0", "-50", Integer.MAX_VALUE + "0", Integer.MIN_VALUE + "0"};

        boolean result = intParser.canParse(invalidInput);

        assertFalse(result);
    }

    @Test
    void LongParser_정상적인_long_범위의_문자열은_true를_반환한다() {
        String[] validInput = {"100", "200", "0", "-50", Long.MAX_VALUE + "", Long.MIN_VALUE + ""};

        boolean result = longParser.canParse(validInput);

        assertTrue(result);
    }

    @Test
    void LongParser_비정상적인_long_범위의_문자열은_false를_반환한다() {
        String[] invalidInput = {"100", "200", "0", "-50", Long.MAX_VALUE + "0", Long.MIN_VALUE + "0"};

        boolean result = longParser.canParse(invalidInput);

        assertFalse(result);
    }

    @Test
    void IntParser_정상적인_값을_parse_성공() {
        String[] validInput = {"100", "200", "0", "-50", Integer.MAX_VALUE + "", Integer.MIN_VALUE + ""};

        List<Number> result = intParser.parse(validInput);

        Assertions.assertThat(result).containsExactly(100, 200, 0, -50, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    @Test
    void LongParser_정상적인_값을_parse_성공() {
        String[] validInput = {"100", "200", "0", "-50", Long.MAX_VALUE + "", Long.MIN_VALUE + ""};

        List<Number> result = longParser.parse(validInput);

        Assertions.assertThat(result).containsExactly(100L, 200L, 0L, -50L, Long.MAX_VALUE, Long.MIN_VALUE);
    }
}
