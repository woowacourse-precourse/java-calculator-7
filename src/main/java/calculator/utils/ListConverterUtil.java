package calculator.utils;

import calculator.enums.CustomExceptionMessage;
import java.util.ArrayList;
import java.util.List;

public class ListConverterUtil {


    public static List<Integer> convertToPositiveIntegers(List<String> strings) {
        List<Integer> positiveIntegers = new ArrayList<>();
        for (String string : strings) {
            int integer;
            try {
                integer = Integer.parseInt(string);
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException(
                        CustomExceptionMessage.FIND_NOT_INTEGER.getMessage());
            }
            if (integer <= 0) {
                throw new IllegalArgumentException(
                        CustomExceptionMessage.FIND_NEGATIVE_INTEGER.getMessage());
            }
            positiveIntegers.add(integer);
        }
        return positiveIntegers;
    }
}
