package calculator.adder;

import java.util.Objects;

public final class Token {

    private final int value;

    public Token(String token) {
        int number = parseNumber(token);
        validatePositiveNumber(number);
        this.value = number;
    }

    private int parseNumber(String value) {
        if (value.isBlank()) {
            return 0;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePositiveNumber(int value) {
        if (!isPositiveNumber(value)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isPositiveNumber(int value) {
        return value >= 0;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Token token = (Token) o;
        return value == token.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
