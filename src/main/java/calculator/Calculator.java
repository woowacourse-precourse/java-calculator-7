package calculator;


import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final String DEFAULT_DELIMITERS = ",|:";


    public List<Integer> splitString(String input) {
        if (input == null || input.isEmpty()) {
            return List.of(0);
        }

        String delimiter = DEFAULT_DELIMITERS;

        String[] tokens = input.split(delimiter);
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }

        return numbers;
    }

    public Integer sumNumbers(List<Integer> numbers) {
        Integer sum = 0;
        for (Integer i : numbers) {
            sum += i;
        }

        return sum;
    }
}
