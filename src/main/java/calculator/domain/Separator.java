package calculator.domain;

import java.util.Objects;

public class Separator {
    public final char separator;

    public Separator(char separator) {
        this.separator = separator;
    }

    public boolean isSame(char separator) {
        return this.separator == separator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return this.separator == ((Separator) o).separator;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.separator);
    }

    @Override
    public String toString() {
        return String.valueOf(this.separator);
    }
}
