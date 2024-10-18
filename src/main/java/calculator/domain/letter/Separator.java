package calculator.domain.letter;

import java.util.Objects;

public class Separator {
    private final String separator;

    public Separator(String separator) {
        this.separator = separator;
    }

    @Override
    public String toString() {
        return separator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Separator separator1 = (Separator) o;
        return Objects.equals(separator, separator1.separator);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(separator);
    }
}
