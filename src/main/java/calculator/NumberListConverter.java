package calculator;

import java.util.Arrays;
import java.util.List;

public class NumberListConverter {

    public static List<Integer> toNumbers(String[] values) {
        return Arrays.stream(values)
                .map(Integer::parseInt)
                .toList();
    }
}
