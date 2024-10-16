package calculator.domain.vo.delimiter;

import java.util.Objects;

public class Delimiter {

    private final String value;

    private Delimiter(String value) {
        this.value = value;
    }

    protected void validate(String value) {
        if (value == null || value.length() != 1) {
            throw new IllegalArgumentException();
        }
    }

    public static Delimiter from(String value) {
        return new Delimiter(value);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Delimiter)) {
            return false;
        }
        Delimiter delimiter = (Delimiter) o;
        return Objects.equals(delimiter, delimiter.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
