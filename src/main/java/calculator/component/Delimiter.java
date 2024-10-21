package calculator.component;

import java.util.List;

public class Delimiter {

    private final List<Character> delimiter;

    private Delimiter() {
        this.delimiter = List.of(',', ':');
    }

    private Delimiter(String delimiterExpression) {
        if (delimiterExpression.charAt(2) == '\\') {
            throw new IllegalArgumentException();
        }

        this.delimiter = List.of(',', ':', delimiterExpression.charAt(2));
    }

    public static Delimiter of(String expression) {
        if (expression.startsWith("//")) {
            return new Delimiter(expression);
        }

        return new Delimiter();
    }

    @Override
    public String toString() {
        String delimiters = delimiter.stream()
                .map(String::valueOf)
                .reduce("", String::concat);

        return "[" + delimiters + "]";
    }
}
