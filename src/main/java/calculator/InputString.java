package calculator;

import java.util.Arrays;
import java.util.List;

public class InputString {
    private List<Integer> numbers;

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

        return Arrays.stream(input.split("[,:]"))
                .map(Integer::valueOf)
                .toList();
    }

    public int getSum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
