package calculator.model;

import java.util.List;

public class Tokens {
    private final List<Token> values;

    private Tokens(List<Token> values) {
        this.values = values;
    }

    public static Tokens of(List<Token> values) {
        return new Tokens(values);
    }

    public int sum() {
        return values.stream()
                .mapToInt(Token::getCost)
                .sum();
    }

}
