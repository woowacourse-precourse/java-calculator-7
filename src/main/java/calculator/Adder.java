package calculator;

import java.util.ArrayList;
import java.util.List;

public class Adder {
    List<Integer> extractedNumList = new ArrayList<Integer>();

    Adder(List<Integer> numList) {
        this.extractedNumList = numList;
    }

    public int getSum() {
        return extractedNumList.stream().mapToInt(Integer::intValue).sum();
    }
}
