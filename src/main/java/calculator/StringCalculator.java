package calculator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String input) {
        try {
            String[] tokens;
            if (input.startsWith("//")) {
                int delimiterIndex = input.indexOf("\\n");
                String customDelimiter = input.substring(2, delimiterIndex);
                input = input.substring(delimiterIndex + 2);
                tokens = input.split(customDelimiter);
            } else {
                tokens = input.split("[,|:]");
            }

            int[] numbers = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();

            // 음수 처리
            String negativeNumbers = Arrays.stream(numbers)
                    .filter(n -> n < 0)
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(", "));

            if (!negativeNumbers.isEmpty()) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + negativeNumbers);
            }

            return Arrays.stream(numbers).sum();  // 합계 반환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 값입니다.");
        }
    }
}
