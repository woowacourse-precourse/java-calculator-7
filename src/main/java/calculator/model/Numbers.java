package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void addNumber(Integer... numbers) {
        for (Integer number : numbers) {
            if (number == null || number < 0) {
                throw new IllegalArgumentException("숫자가 0이거나 NULL이어서는 안됩니다.");
            }
            this.numbers.add(number);
        }
    }

    public Integer sumNumbers() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
