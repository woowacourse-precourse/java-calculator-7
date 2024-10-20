package calculator.parser;

public class ParserSelector {

    public static StringParser select(String str) {
        if (str.startsWith("//")) {
            return new CustomStringParser();
        } else {
            return new BasicStringParser();
        }
    }
}

