package calculator.util;

import calculator.domain.Delimiter;

import java.util.Arrays;

public class NumberConvertor {

    public static int[] stringToInt(String str) {
        String removedEnrollmentChar = Delimiter.removeEnrollmentChar(str);

        return Arrays.stream(removedEnrollmentChar.split(Delimiter.getDelimiter()))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}