package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public record Numbers(
    List<Long> numbers
) {
    public static Numbers parseOf(String str, Separators separators) {
        if (str.startsWith("//")) {
            String[] split = str.split(Pattern.quote("\\n"));

            if (split.length == 2) str = split[1];
        }

        String[] numbers = str.split(separators.getRegex());

        return new Numbers(
            Arrays.stream(numbers)
                .map(Numbers::parseNumber)
                .toList()
        );
    }

    private static long parseNumber(String str) {
        long number;
        try {
            number = str.isBlank() ? 0 : Long.parseLong(str);

            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력 불가능");
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 파싱할 수 없음 : " + str, e);
        }

        return number;
    }

    public long sum() {
        return numbers.stream()
            .mapToLong(Long::longValue)
            .reduce(0L, (acc, num) -> {
                if (acc > Long.MAX_VALUE - num) {
                    throw new IllegalArgumentException("결과가 Long 범위를 초과했습니다.");
                }
                return acc + num;
            });
    }
}
