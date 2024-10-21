package calculator;

import java.util.Arrays;
import java.util.List;

public class InputString {
    private final List<Integer> numbers;

    public InputString(String input) {
        this.numbers = inputToList(input);
    }

    private boolean isInputEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private List<Integer> inputToList(String input) {
        if (isInputEmpty(input)) {
            return List.of();
        }

        String delimiter = findDelimiter(input);

        if (input.startsWith("//")) {
            input = input.substring(4);
        }

        return Arrays.stream(input.split(delimiter))
                .map(Integer::valueOf)
                .toList();
    }

    private String findDelimiter(String input) {
        if (input.startsWith("//")) {
            return input.substring(2, 3);
        }
        return "[,:]";
    }

    public int getSum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
