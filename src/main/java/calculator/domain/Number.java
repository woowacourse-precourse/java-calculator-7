package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private List<Integer> numbers;

    public Number() {
        numbers = new ArrayList<>();
    }
    
    public void addValidNumber(String n) {
        if (!n.trim().isEmpty()) {
            try {
                Integer value = Integer.valueOf(n);
                addNumber(value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 계산할 수 있습니다."); // 에러 메시지 수정
            }
        }
    }

    public void addNumber(Integer value) {
        validatePositiveNumber(value);
        numbers.add(value);
    }

    public void validatePositiveNumber(Integer value) {
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
