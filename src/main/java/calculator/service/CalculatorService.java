package calculator.service;

import calculator.model.InputFormatter;

public class CalculatorService {
    public Long calculateSumFromString(String input) {
        // 1. 입력값을 구분자로 구분하여 문자열 배열로 만듬.
        InputFormatter inputFormatter = new InputFormatter();
        String[] strInput = inputFormatter.splitByDelimiter(input);
        return null;
    }
}
