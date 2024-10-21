package calculator.domain.adder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.domain.parser.InputParser.ParsedInput;
import org.junit.jupiter.api.Test;

public class NumberAdderTest {

    private final NumberAdder numberAdder = new NumberAdder();

    @Test
    void 숫자_하나_테스트() {
        ParsedInput parsedInput = new ParsedInput(new String[]{"1"});

        String result = numberAdder.adder(parsedInput);

        assertEquals("1", result);
    }

    @Test
    void 숫자_두개_테스트() {
        ParsedInput parsedInput = new ParsedInput(new String[]{"1", "2"});

        String result = numberAdder.adder(parsedInput);

        assertEquals("3", result);
    }

    @Test
    void 숫자_세개_테스트() {
        ParsedInput parsedInput = new ParsedInput(new String[]{"1", "2", "3"});

        String result = numberAdder.adder(parsedInput);

        assertEquals("6", result);
    }

    @Test
    void int_범위_초과_테스트() {
        ParsedInput parsedInput = new ParsedInput(new String[]{"1000000000000", "20", "3"});

        String result = numberAdder.adder(parsedInput);

        assertEquals("1000000000023", result);
    }

    @Test
    void 소수점_테스트() {
        ParsedInput parsedInput = new ParsedInput(new String[]{"1.1", "2.2", "3.3"});

        String result = numberAdder.adder(parsedInput);

        assertEquals("6.6", result);
    }

}
