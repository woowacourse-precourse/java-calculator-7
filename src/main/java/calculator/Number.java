package calculator;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private final List<Integer> numbers;

    public Number() {
        this.numbers = new ArrayList<>();
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public int getSum() {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }
}
