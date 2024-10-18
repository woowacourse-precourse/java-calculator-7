package calculator.domain;

import java.util.Objects;

public class DefaultDelimiterInput extends Input {

    private final String text;

    private DefaultDelimiterInput(String text) {
        this.text = text;
    }

    public static Input from(String text) {
        return new DefaultDelimiterInput(text);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DefaultDelimiterInput that)) {
            return false;
        }
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
