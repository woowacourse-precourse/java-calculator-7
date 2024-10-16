package calculator.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NumList {

    private final List<Num> numLists;

    public NumList() {
        this.numLists = new ArrayList<>();
    }

    public int sum() {
        return Num.total(numLists);
    }

    public void addNum(Num num) {
        numLists.add(num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NumList numList = (NumList) o;
        return Objects.equals(numLists, numList.numLists);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numLists);
    }
}
