package calculator.entity;

import java.util.ArrayList;
import java.util.List;

public class NumList {

    private final List<Num> numLists;

    public NumList() {
        this.numLists = new ArrayList<>();
    }

    public NumList(List<Num> numList) {
        this.numLists = numList;
    }


    public int sum() {
        return Num.total(this.numLists);
    }


}
