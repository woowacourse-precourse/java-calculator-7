package calculator.model;

import java.util.List;

public class Calculator {

    List<Integer> numList;

    public Calculator(List<Integer> numList) {
        this.numList = numList;
    }

    public Integer addNums() {
        int total = 0;

        for (int num : numList) {
            total += num;
        }

        return total;
    }
}
