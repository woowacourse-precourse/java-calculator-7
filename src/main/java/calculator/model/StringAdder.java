package calculator.model;

import java.util.Arrays;

public class StringAdder {
    public int addString(String input, String delimiter){
        String[] numbers = input.split(delimiter);
        int result = Arrays.stream(numbers)
                .filter(number->number.isEmpty()==false)
                .mapToInt(Integer::parseInt)
                .sum();
        return result;
    }
}
