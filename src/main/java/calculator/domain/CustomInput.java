package calculator.domain;

import java.util.Objects;

public class CustomDelimiterInput extends Input {

    private final String text;

    private CustomDelimiterInput(String text) {
        this.text = text;
    }

    public static Input from(String text) {
        return new CustomDelimiterInput(text);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CustomDelimiterInput that)) {
            return false;
        }
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
