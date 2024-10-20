package calculator.model;

import java.util.Arrays;

public class StringAdder {
    public int addString(String input, String delimiter){
        String[] numbers = input.split(delimiter);
        return Arrays.stream(numbers)
                .filter(number->!number.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
