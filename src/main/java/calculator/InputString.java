package calculator;

import java.util.Arrays;
import java.util.List;

public class InputString {
    private List<Integer> numbers;

    public InputString(String input) {
        if (isInputEmpty(input)) {
            return;
        }
        this.numbers = inputToList(input);
    }

    private boolean isInputEmpty(String input) {
        if(input == null || input.isEmpty()) {
            this.numbers = List.of();
            return true;
        }
        return false;
    }

    private List<Integer> inputToList(String input) {
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
