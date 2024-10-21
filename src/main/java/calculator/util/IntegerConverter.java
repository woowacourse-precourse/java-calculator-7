package calculator.util;

import calculator.validator.Validator;

import java.util.List;

public class IntegerConverter {
    private final Validator validator = new Validator();
    public List<Integer> convertToIntegerList(List<String> strings) {
        List<Integer> list = strings.stream()
                .filter(IntegerConverter::isNumeric)
                .map(Integer::parseInt)
                .toList();

        validator.validateNumber(list);

        return list;
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        return str.chars().allMatch(Character::isDigit);
    }
}
