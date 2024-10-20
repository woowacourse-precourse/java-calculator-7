package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int calculate(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        List<Integer> numbers = new ArrayList<>();

        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
