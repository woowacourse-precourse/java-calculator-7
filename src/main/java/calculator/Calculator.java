package calculator;

import calculator.util.CustomDelimiterParser;
import calculator.util.NumberExtractor;

import java.util.List;

public class Calculator {

    public Integer calculate(String inputStr) {
        String delimiter = ",|:";

        String[] result = CustomDelimiterParser.parse(inputStr, delimiter);
        inputStr = result[0];
        delimiter = result[1];

        List<Integer> nums = NumberExtractor.extractNums(inputStr, delimiter);
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }
}
