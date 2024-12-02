package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public List<Integer> convert(List<String> strs) {
        return strs.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
