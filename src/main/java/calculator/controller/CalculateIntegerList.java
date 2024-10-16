package calculator.controller;

import calculator.model.InputString;
import java.util.List;

public class CalculateIntegerList {

    public static int calculateResult(InputString inputString) {
        List<Integer> numberList = inputString.getNumberList();
        int sum = 0;
        for (Integer number : numberList) {
            sum += number;
        }
        return sum;
    }
}
