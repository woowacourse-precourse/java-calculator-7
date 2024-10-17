package calculator.controller;

import calculator.model.InputString;
import java.util.List;

public class CalculateIntegerList {

    public static int calculateResult(InputString inputString) {
        List<String> numberList = inputString.numberList();
        int sum = 0;
        for (String number : numberList) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
