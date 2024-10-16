package calculator.entity;

import static calculator.service.SeparatorService.CUSTOM_SEPARATOR_IDX;

import java.util.Objects;

public class Index {

    // 엔티티 계층에서 작업할 수 있도록
    protected final Integer value;

    public Index(Integer value) {
        this.value = value;
    }

    public Index increase() {
        return new Index(value + 1);
    }

    public Index customSeparatorIdx() {
        return new Index(value + CUSTOM_SEPARATOR_IDX);
    }

    public Index plus(Integer plusValue) {
        return new Index(value + plusValue);
    }

    public boolean isLessThanOrEqual(Index index) {
        return value <= index.value;
    }

    public boolean isLess(Index index) {
        return value < index.value;
    }

    //TODO Index 값을 사용하는 것을 Index 에서 작업하도록 하자.


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Integer index = ((Index) o).value;
        return Objects.equals(value, index);
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
