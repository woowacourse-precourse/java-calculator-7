package calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    private final List<String> stringList;

    public Converter(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<Integer> convertList() {
        return stringList.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
