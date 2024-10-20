package calculator;

import java.util.regex.Pattern;

public class Delimiter {

    private final String delimiters;

    public Delimiter(String delimiters) {
        this.delimiters = delimiters;
    }

    public static Delimiter defaultDelimiter() {
        return new Delimiter(DefaultDelimiter.getAllDelimiters());
    }

    public static Delimiter customDelimiter(String customDelimiter) {
        return new Delimiter(DefaultDelimiter.getAllDelimiters() + "|" + Pattern.quote(customDelimiter));
    }

    public String getDelimiters() {
        return delimiters;
    }
}
