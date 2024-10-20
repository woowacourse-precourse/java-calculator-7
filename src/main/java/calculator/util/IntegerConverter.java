package calculator.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegerConverter {
    public static List<Integer> convertToIntegerList(List<String> strings) {
        List<Integer> list = strings.stream()
                .filter(IntegerConverter::isNumeric)
                .map(Integer::parseInt)
                .toList();

        validateIsPositive(list);

        return list;
    }

    private static void validateIsPositive(List<Integer> list) {
        if (!list.stream().allMatch(number -> number > 0)) {
            throw new IllegalArgumentException("숫자는 양수여야 합니다.");
        }
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        return str.chars().allMatch(Character::isDigit);
    }
}
