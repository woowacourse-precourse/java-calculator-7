package calculator.util;

import calculator.validator.Validator;

import java.util.List;

public class IntegerConverter {
    public static List<Integer> convertToIntegerList(List<String> strings) {
        List<Integer> list = strings.stream()
                .filter(IntegerConverter::isNumeric)
                .map(Integer::parseInt)
                .toList();

        Validator.validateNumber(list);

        return list;
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        return str.chars().allMatch(Character::isDigit);
    }
}
