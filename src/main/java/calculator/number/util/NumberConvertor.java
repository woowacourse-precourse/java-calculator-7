package calculator.number.util;

import calculator.constant.ErrorMessage;
import calculator.separator.domain.Separator;

import java.util.Arrays;
import java.util.List;

public class NumberConvertor {
    public static long stringToLongBlankIsZero(String input) {
        try {
            if (input.isBlank()) return 0L;
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MAX_VALUE_ERROR);
        }
    }


    public static List<Long> splitBySeparatorToList(String extractValue, Separator separator) {
        return Arrays.stream(extractValue.split(separator.getSeparator()))
                .map(NumberConvertor::stringToLongBlankIsZero)
                .toList();
    }
}
