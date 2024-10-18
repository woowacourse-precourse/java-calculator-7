package calculator.domain;

import java.util.Objects;

public abstract class Input {

    private final String text;

    public Input(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Input input)) {
            return false;
        }
        return Objects.equals(text, input.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
