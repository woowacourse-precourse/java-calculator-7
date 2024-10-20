package calculator.model;

import java.util.List;

public class Calculator {
    private final List<Long> numbers;

    // 여기 나중에 서비스 로직으로 분리
    public Calculator(List<Long> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("숫자 목록은 비어 있을 수 없습니다.");
        }
        this.numbers = numbers;
    }

    public long sum() {
        return numbers.stream()
                .mapToLong(Long::longValue)
                .sum();
    }
}
