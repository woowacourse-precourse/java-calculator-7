package calculator.domain;

import java.util.Objects;

public class Token {
    private final int cost;

    public Token(String cost) {
        this.cost = Integer.parseInt(cost);
    }

    public int getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Token token)) {
            return false;
        }
        return cost == token.cost;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cost);
    }
}
