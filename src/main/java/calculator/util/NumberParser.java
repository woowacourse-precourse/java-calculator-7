package calculator.util;

import java.util.Arrays;
import java.util.List;

public class NumberParser {
    public List<Integer> parseNumbers(String[] tokens) {
        return Arrays.stream(tokens).map(Integer::parseInt).toList();
    }
}
