package calculator.domain;

import java.util.List;
import java.util.Objects;

public class Numbers {

    private List<Number> values;

    private Numbers(List<Number> values) {
        this.values = values;
    }

    public static Numbers from(List<Number> values) {
        return new Numbers(values);
    }

    public List<Number> getValues() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Numbers numbers = (Numbers) o;
        return Objects.equals(getValues(), numbers.getValues());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValues());
    }
}
