package calculator.common;

import java.util.List;
import java.util.stream.Stream;

public class NumberConverter {
    public List<Long> convert(String[] numbers) {
        List<Long> number;
        try {
            number = Stream.of(numbers)
                    .mapToLong(Long::parseLong)
                    .boxed()
                    .toList();
        } catch (NumberFormatException e) { // 문자, 빈 칸 등이 입력되었을 경우
            throw new IllegalArgumentException();
        }
        return number;
    }
}
