package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberList {

    private final List<Integer> numbers;
    private int sum;

    private NumberList(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        hasNegativeNumbers();
        this.sum = calculateSum();
    }

    public static NumberList extractNumbersFrom(String[] input) {
        List<Integer> numbers = new ArrayList<>();

        for (String s : input) {
            if (s.isEmpty()) {
                continue;
            }

            int number = Integer.parseInt(s);
            numbers.add(number);
        }

        return new NumberList(numbers);
    }

    public int getSum() {
        return sum;
    }

    private void hasNegativeNumbers() {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
            }
        }
    }

    private int calculateSum() {
        int sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }
}
