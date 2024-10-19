package calculator;

import java.util.Arrays;
import java.util.List;

public class NumberListConverter {

    public static List<PositiveNumber> toNumbers(String[] values) {
        return Arrays.stream(values)
                .map(v -> new PositiveNumber(Integer.parseInt(v)))
                .toList();
    }
}
