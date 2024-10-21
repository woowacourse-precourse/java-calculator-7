package calculator.model;

import static calculator.util.StringCalculatorUtils.convertToIntArray;
import static calculator.util.StringCalculatorUtils.findIndex;
import static calculator.util.StringCalculatorUtils.isCustom;
import static calculator.util.StringCalculatorUtils.parseBasic;
import static calculator.util.StringCalculatorUtils.parseCustom;

import java.util.Arrays;

public class StringCalculator {

    public int calculate(String input) {
        String[] parsedInput = parse(input);
        return sum(parsedInput);
    }

    private String[] parse(String input) {

        if (isCustom(input)) {
            int[] indices = findIndex(input);
            return parseCustom(input, indices);
        }

        return parseBasic(input);
    }

    private int sum(String[] parsed) {
        return Arrays.stream(convertToIntArray(parsed)).sum();
    }
}
