package calculator.parser;

public class EmptyStringParser implements StringParser {
    @Override
    public Long[] parseToLong(String input) {
        return new Long[0];
    }
}
