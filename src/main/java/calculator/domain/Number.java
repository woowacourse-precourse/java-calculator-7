package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private List<Integer> numbers;

    public Number() {
        numbers = new ArrayList<>();
    }

    // TODO: 메서드명 다시 생각해보기
    public void validateNumber(String n) {
        if (!n.isEmpty()) {
            try {
                Integer value = Integer.valueOf(n);
                addNumber(value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }

    public void addNumber(Integer value) {
        validatePositiveNumber(value);
        numbers.add(value);
    }

    private void validatePositiveNumber(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
    }

    public int plusNumber() {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
