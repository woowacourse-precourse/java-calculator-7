package calculator.entity;

import static calculator.utils.Constants.CUSTOM_SEPARATOR_END_IDX;
import static calculator.utils.Constants.CUSTOM_SEPARATOR_IDX;
import static calculator.utils.Constants.CUSTOM_DESIGNATOR_END;
import static calculator.utils.Constants.CUSTOM_DESIGNATOR_START;

import java.util.Objects;

public class Index implements Comparable<Index> {

    private final Integer value;

    public Index(Integer value) {
        this.value = value;
    }

    public Index increase() {
        return new Index(value + 1);
    }

    public Index customSepIdx() {
        return new Index(value + CUSTOM_SEPARATOR_IDX.value);
    }

    public Index plus(Index plusValue) {
        return new Index(value + plusValue.value);
    }

    public Index minus(Index minusValue) {
        return new Index(value - minusValue.value);
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
        Integer compareValue = ((Index) o).value;
        return Objects.equals(value, compareValue);
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

    @Override
    public int compareTo(Index compareIdx) {
        return Integer.compare(this.value, compareIdx.value);
    }

    protected boolean isStartCustomSep(String value) {
        return value.startsWith(CUSTOM_DESIGNATOR_START, this.value);
    }

    protected boolean isEndCustomSep(String value) {
        return value.startsWith(CUSTOM_DESIGNATOR_END, this.value + CUSTOM_SEPARATOR_END_IDX.value);
    }

    protected String oneLetter(String value) {
        char charLetter = value.charAt(this.value);
        return String.valueOf(charLetter);
    }


}
