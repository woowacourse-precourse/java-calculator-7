package calculator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public List<Integer> convertStringToIntegerList(String inputString) {
        return Arrays.stream(inputString.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
    }
}
