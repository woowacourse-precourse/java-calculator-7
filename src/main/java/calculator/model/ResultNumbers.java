package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class ResultNumbers {

    private List<Integer> numberList = new ArrayList<>();
    private int result;

    public void addNumberList(int num) {
        this.numberList.add(num);
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

}
