package calculator.controller;

import java.util.List;
import java.util.stream.Stream;

public class NumberConverter {
    public List<Long> convert(String[] numbers) {
        List<Long> number;
        try {
            number = Stream.of(numbers)
                    .mapToLong(Long::parseLong)
                    .filter(num -> {
                        if (num <= 0) { // 입력된 숫자가 음수인 경우
                            throw new IllegalArgumentException();
                        }
                        return true;
                    })
                    .boxed()
                    .toList();
        } catch (NumberFormatException e) { // 문자, 빈 칸, 소수가 입력되었을 경우
            throw new IllegalArgumentException();
        }
        return number;
    }
}
