package calculator.domain;

import calculator.util.StringParser;

import java.util.List;

public class Calculator {
    private final StringParser stringParser;

    public Calculator() {
        stringParser = new StringParser();
    }

    public int calculateSumFromString(String inputString) {
        List<Integer> list = stringParser.parseNumbers(inputString);
        int sum = 0;
        for (int num : list) {
            sum += num;
        }

        return sum;
    }
}
