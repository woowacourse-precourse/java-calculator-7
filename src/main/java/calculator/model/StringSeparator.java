package calculator.model;

import java.util.Arrays;
import java.util.List;

public class StringSeparator {

    public List<Integer> extractNumbers(String input) {
        String[] numbers = separateNumbers(input);
        return Arrays.stream(numbers)
            .map(Integer::parseInt)
            .toList();
    }

    private String[] separateNumbers(String inputString) {
        return inputString.split(",|;");
    }
}
