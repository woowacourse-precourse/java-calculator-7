package calculator.model;

import java.util.List;

public class Result {
    int value;

    public Result(List<Integer> inputList) {
        value = 0;
        for (int element : inputList) {
            value += element;
        }
    }

    public int getValue() {
        return value;
    }
}
