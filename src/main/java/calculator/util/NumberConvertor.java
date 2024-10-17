package calculator.util;

import calculator.domain.Separator;

import java.util.Arrays;

public class NumberConvertor {

    public static int[] stringToInt(String str) {
        String removedEnrollmentChar = Separator.removeEnrollmentChar(str);

        return Arrays.stream(removedEnrollmentChar.split(Separator.getSeparator()))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}