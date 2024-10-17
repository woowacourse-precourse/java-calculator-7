package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private final List<Integer> numberList;

    public Number() {
        this.numberList = new ArrayList<>();
    }

    public void setNumberList(int num) {
        numberList.add(num);
    }

    public int getSum() {
        int sum = 0;
        for (int num : numberList) {
            sum += num;
        }

        return sum;
    }
}
