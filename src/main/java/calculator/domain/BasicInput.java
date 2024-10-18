package calculator.domain;

import java.util.Objects;

public class BasicDelimiterInput extends Input {

    private final String text;

    private BasicDelimiterInput(String text) {
        this.text = text;
    }

    public static Input from(String text) {
        return new BasicDelimiterInput(text);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof BasicDelimiterInput that)) {
            return false;
        }
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
