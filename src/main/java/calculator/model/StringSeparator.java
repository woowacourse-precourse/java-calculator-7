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
        if (inputString.substring(0, 2).equals("//") && inputString.substring(3, 5).equals("\\n")) {
            return separateNumbersByCustom(inputString);
        }
        return inputString.split(",|;");
    }

    private String[] separateNumbersByCustom(String input) {
        char customSeparator = input.charAt(2);
        String numbers = input.substring(5);
        return numbers.split(",|;|" + customSeparator);
    }
}
