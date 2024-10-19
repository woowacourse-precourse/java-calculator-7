package calculator.mock;

import calculator.parser.CustomStringParser;
import calculator.parser.DefaultStringParser;
import calculator.parser.EmptyStringParser;
import calculator.parser.StringParser;

public class FakeStringParser implements StringParser {

    @Override
    public Long[] parseToLong(String input) {
        StringParser parser = selectParser(input);
        return parser.parseToLong(input);
    }

    private StringParser selectParser(String input) {
        if (input.startsWith("//")) {
            return new CustomStringParser();
        } else if (input.isEmpty()) {
            return new EmptyStringParser();
        }
        return new DefaultStringParser();
    }
}
