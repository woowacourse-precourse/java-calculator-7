package calculator.model;

import java.util.ArrayList;
import java.util.List;

// 분리되어진 number를 다루는 객체
public class Numbers {
    private final List<Number> numbers;

    public Numbers() {
        this.numbers = new ArrayList<>();
    }

    public void add(Number number) {
        numbers.add(number);
    }

    // numbers의 총 합을 알려주는 메서드
    public int sum() {
        return numbers.stream().mapToInt(Number::getNumber).sum();
    }
}
