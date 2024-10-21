package calculator.domain;

import java.util.regex.Pattern;

public class Delimiter {

    private final char symbol;

    public Delimiter(char symbol) {
        this.symbol = symbol;
    }

    public String asPattern() {
        return Pattern.quote(Character.toString(symbol));
    }
}