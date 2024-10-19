package calculator.service;

import calculator.model.Calculator;
import calculator.model.InputFormatter;
import calculator.model.StringFormatter;

public class CalculatorService {
    public int calculateSumFromString(String input) {
        // 1. 입력값을 구분자로 구분하여 문자열 배열로 만듬.
        String[] strInput = InputFormatter.splitByDelimiter(input);
        int[] intArr = StringFormatter.toIntArr(strInput);

        return Calculator.arrSum(intArr);
    }
}
