package calculator.service;

import java.util.Arrays;
import java.util.List;

public class Converter {
    public List<Integer> convertToNumbers(String s, String delimiters) {
        return Arrays.stream(s.split(delimiters))
                .map(Integer::parseInt)
                .toList();
    }
}