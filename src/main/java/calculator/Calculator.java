package calculator;

import calculator.handler.InputHandler;
import calculator.handler.OutputHandler;
import calculator.util.CustomDelimeterParser;
import calculator.util.NumberExtractor;

import java.util.List;

public class Calculator {

    public Integer calculate(String inputStr) {
        String delimiter = ",|:";

        String[] result = CustomDelimeterParser.parse(inputStr, delimiter);
        inputStr = result[0];
        delimiter = result[1];

        List<Integer> nums = NumberExtractor.extractNums(inputStr, delimiter);
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }
}
