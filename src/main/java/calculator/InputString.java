package calculator;

import java.util.Arrays;
import java.util.List;

public class InputString {
    private List<Integer> numbers;

    public InputString(String input) {
        if(input == null || input.isEmpty()) {
            this.numbers = List.of();
            return;
        }
        String[] numbers = input.split("[,:]");
        this.numbers = Arrays.stream(numbers)
                .map(Integer::valueOf)
                .toList();
    }

    public int getSum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
