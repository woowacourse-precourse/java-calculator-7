package calculator.entity;

import static calculator.service.SeparatorService.CUSTOM_SEPARATOR_IDX;

import java.util.Objects;

public class Index {

    protected int value;

    public Index(int value) {
        this.value = value;
    }

    public void increase() {
        this.value++;
    }

    public void decrease() {
        this.value--;
    }


    public Index customSeparatorIdx() {
        return new Index(value + CUSTOM_SEPARATOR_IDX);
    }

    public void plus(int plusValue) {
        this.value += plusValue;
    }

    public boolean isLessThanOrEqual(Index index) {
        return value <= index.value;
    }

    public boolean isLess(Index index) {
        return value < index.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Index index = (Index) o;
        return value == index.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Index{" +
            "value=" + value +
            '}';
    }


}
