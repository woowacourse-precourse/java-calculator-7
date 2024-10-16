package calculator.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NumList {

    private final List<Num> numLists;

    public NumList() {
        this.numLists = new ArrayList<>();
    }

    public void addNum(Num num) {
        numLists.add(num);
    }

    public Integer sum() {
        return Num.total(numLists);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        List<Num> compareNumlist = ((NumList) o).numLists;
        return Objects.equals(numLists, compareNumlist);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numLists);
    }
}
