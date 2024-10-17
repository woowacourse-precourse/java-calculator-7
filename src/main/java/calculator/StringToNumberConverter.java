package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringToNumberConverter {
    public static List<Integer> convert(List<String> input) {
        List<Integer> result = new ArrayList<>();
        for (String s : input) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }
}
