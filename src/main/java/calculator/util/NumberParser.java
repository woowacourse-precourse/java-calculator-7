package calculator.util;

import java.util.Arrays;
import java.util.List;

public class NumberParser {
    public List<Integer> parseNumbers(String[] tokens) {
        try {
            return Arrays.stream(tokens).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public void validateNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
        }
    }
}
