package calculator.domain;

import java.util.Objects;

public class Number {

    private Integer value;

    public Number(Integer value) {
        this.value = value;
    }

    public Number() {
        this.value = 0;
    }

    public void addNumber(final Number number) {
        this.value += number.value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Number number))
            return false;
        return Objects.equals(value, number.value);
    }
}
