package calculator;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public List<Integer> convert(List<String> input) {
        try {
            return input.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
