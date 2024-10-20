package calculator;

import java.util.List;

public class InputValidator {

    public static void validateNumbers(List<Integer> numbers) {
        List<Integer> negativeNumbers = numbers.stream()
                .filter(num -> num < 0)
                .toList();
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException(
                    String.format("음수는 허용되지 않습니다: %s", negativeNumbers)
            );
        }
    }
}
