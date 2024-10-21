package calculator.component.parser;

public class ParserFactory {

    public static Parser of(String expression) {
        return new DefaultParser(expression);
    }
}
