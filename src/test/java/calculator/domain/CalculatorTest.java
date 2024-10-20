package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.domain.parser.InputParser.ParsedInput;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void 숫자_하나_테스트() {
        ParsedInput parsedInput = new ParsedInput(new String[]{"1"});

        String result = calculator.calculate(parsedInput);

        assertEquals("1", result);
    }

    @Test
    void 숫자_두개_테스트() {
        ParsedInput parsedInput = new ParsedInput(new String[]{"1", "2"});

        String result = calculator.calculate(parsedInput);

        assertEquals("3", result);
    }

    @Test
    void 숫자_세개_테스트() {
        ParsedInput parsedInput = new ParsedInput(new String[]{"1", "2", "3"});

        String result = calculator.calculate(parsedInput);

        assertEquals("6", result);
    }

    @Test
    void int_범위_초과_테스트() {
        ParsedInput parsedInput = new ParsedInput(new String[]{"1000000000000", "20", "3"});

        String result = calculator.calculate(parsedInput);

        assertEquals("1000000000023", result);
    }

}
