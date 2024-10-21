package calculator.utils;

import java.util.ArrayList;
import java.util.List;

public class ListConverterUtil {


    public static List<Integer> convertToPositiveIntegers(List<String> strings) {
        List<Integer> positiveIntegers = new ArrayList<>();
        for (String string : strings) {
            Integer integer = Integer.parseInt(string);
            positiveIntegers.add(integer);
        }
        return positiveIntegers;
    }
}
