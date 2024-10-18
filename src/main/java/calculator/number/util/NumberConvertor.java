package calculator.number.util;

import calculator.constant.ErrorMessage;
import java.util.List;

public class NumberConvertor {
    public static long stringToLongBlankIsZero(String input) {
        try {
            if (input.isBlank()) return 0L;
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.REGEX_ERROR);
        }
    }


    public static List<Long> stringListToLongList(List<String> numberInfo) {
        return numberInfo.stream()
                .map(NumberConvertor::stringToLongBlankIsZero)
                .toList();
    }
}
