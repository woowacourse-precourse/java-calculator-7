package calculator;

import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers of(List<String> strings) {
        System.out.println(strings);
        List<Number> numbers = toNumbers(strings);
        return new Numbers(numbers);
    }

    private static List<Number> toNumbers(List<String> stringNumbers) {
        return stringNumbers.stream()
                .map(Number::of)
                .toList();
    }

    // TODO: Console Debugging 용도, 기능 개발 완료 후 사용하지 않으면 제거하기
    public List<Number> getNumbers() {
        return numbers;
    }
}
