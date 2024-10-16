package calculator.domain;

import java.util.List;

public class Calculator {
    // 계산기에서는 숫자만 다룬다.
    private final List<Integer> numbers;

    private Calculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 외부에서 접근 가능한 정적 팩토리 메서드
    public static Calculator of(List<Integer> numbers) {
        return new Calculator(numbers);
    }

    // 리스트에 담긴 숫자들의 합을 구하는 메서드
    public int calculateSum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}