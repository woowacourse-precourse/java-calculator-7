package calculator.util;

import java.util.List;
import java.util.stream.Collectors;

public class IntegerConverter {
    public static List<Integer> convertToIntegerList(List<String> strings) {
        return strings.stream()
                .filter(IntegerConverter::isNumeric)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        return str.chars().allMatch(Character::isDigit);
    }
}
