package calculator.controller;

import calculator.model.InputString;
import java.util.List;

public class CalculateIntegerList {

    private final InputString inputString;

    public CalculateIntegerList(InputString inputString) {
        this.inputString = inputString;
    }

    public int calculate() {
        List<Integer> numberList = inputString.getNumberList();
        int sum = 0;
        for (Integer number : numberList) {
            sum += number;
        }
        return sum;
    }
}
