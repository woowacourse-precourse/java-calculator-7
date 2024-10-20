package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private static final int NUMBER_FOR_EMPTY_INPUT = 0;
    private final List<Integer> numbers;

    public Number() {
        numbers = new ArrayList<>();
    }

    public void handleEmptyData() {
        numbers.add(NUMBER_FOR_EMPTY_INPUT);
    }

    public void convertNumbers(List<String> separatedString) {
        for (String number : separatedString) {
            numbers.add(Integer.parseInt(number));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
