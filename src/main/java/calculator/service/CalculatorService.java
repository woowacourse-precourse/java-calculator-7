package calculator.service;

import calculator.model.Calculator;
import calculator.model.InputFormatter;
import calculator.model.InputValidator;
import calculator.model.StringFormatter;

public class CalculatorService {
    public int calculateSumFromString(String input) {
        // 1. 입력값을 구분자로 구분하여 문자열 배열로 만듬.
        String[] strInput = InputFormatter.splitByDelimiter(input);
        // 2. 입력값의 유효성 검사
        InputValidator.validate(strInput);
        // 3. 문자열 배열 -> int[]
        int[] intArr = StringFormatter.toIntArr(strInput);
        // 4. 계산
        return Calculator.arrSum(intArr);
    }
}
