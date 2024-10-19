package calculator;

import java.util.Arrays;
import java.util.List;

public class InputPreprocessing {

    public static List<Long> of(String input) {
        Delimiter delimiter = new Delimiter(input);
        return Arrays.stream(input.split(delimiter.get()))
                .map(part -> {
                    validateSplit(part);
                    return castingElementToLong(part);
                })
                .toList();
    }

    private static void validateSplit(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("구분자 외의 문자가 존재합니다.");
        }
    }

    private static long castingElementToLong(String input) {
        try {
            long number = Long.parseLong(input);
            validatePositive(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("더하는 값 중 너무 큰 수가 존재합니다.");
        }
    }

    private static void validatePositive(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("더하는 값은 양수만 가능합니다.");
        }
    }
}
